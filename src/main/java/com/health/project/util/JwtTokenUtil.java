package com.health.project.util;

import com.health.project.Repository.token.RefreshTokenRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Getter
@Slf4j
@RequiredArgsConstructor
@Component
public class JwtTokenUtil  {
    @Value("${jwt.token.secret}")
    private String secretKey;
    private final RefreshTokenRepository tokenRepository;

    public Boolean isExpired(String token){
        byte[] accessSecret = secretKey.getBytes(StandardCharsets.UTF_8);
        return Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(accessSecret)).parseClaimsJws(token).getBody()
                .getExpiration().before(new Date());
    }
    public String createToken(String id,Long no, long expireTimeMs){
        Claims claims = Jwts.claims().setSubject(id);
        claims.put("no",no);
        claims.put("roles","user");
        byte[] accessSecret = secretKey.getBytes(StandardCharsets.UTF_8);
        return Jwts.builder()
                .setClaims(claims)//정보를 넣어줌 claims가 포함된 jwt빌더를 반환
                .setIssuedAt(new Date(System.currentTimeMillis()))//시작시간
                .setExpiration(new Date(System.currentTimeMillis()+expireTimeMs))//만료시간
//                .signWith(SignatureAlgorithm.HS256,key)
                .signWith(Keys.hmacShaKeyFor(accessSecret))
                .compact();

    }
    public Claims getclaims(String token){
        byte[] parser_key = secretKey.getBytes(StandardCharsets.UTF_8);
        Claims body = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(parser_key)).parseClaimsJws(token)
                .getBody();
        return body;
    }

    public String createReFreshToken(String id,Long no,Long expireTimeMs) {
        byte[] accessSecret = secretKey.getBytes(StandardCharsets.UTF_8);
        Claims claims = Jwts.claims().setSubject(id);
        claims.put("no", no);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))//시작시간
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs * 100))//만료시간
//                .signWith(SignatureAlgorithm.HS256,key)
                .signWith(Keys.hmacShaKeyFor(accessSecret))
                .compact();
    }
    // Request의 Header에서 AccessToken 값을 가져옵니다. "authorization" : "token'
    public String resolveAccessToken(HttpServletRequest request) {
        if(request.getHeader("authorization") != null )
            return request.getHeader("authorization").substring(7);
        return null;
    }
    // Request의 Header에서 RefreshToken 값을 가져옵니다. "authorization" : "token'
    public String resolveRefreshToken(HttpServletRequest request) {
        if(request.getHeader("refreshToken") != null )
            return request.getHeader("refreshToken").substring(7);
        return null;
    }
    public boolean validateToken(String jwtToken) {
        byte[] accessSecret = secretKey.getBytes(StandardCharsets.UTF_8);
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(accessSecret).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            log.info(e.getMessage());
            return false;
        }
    }
    public boolean existRefreshKey(String jwtToken){
        return tokenRepository.existsByToken(jwtToken);
    }
    public UsernamePasswordAuthenticationToken getAuthentication(String token) {
        Object no = this.getclaims(token).get("no");
        return new UsernamePasswordAuthenticationToken(no, "", List.of(new SimpleGrantedAuthority("Member")));
    }
    public void setHeaderAccessToken(HttpServletResponse response, String accessToken) {
        response.setHeader("authorization", "Bearer "+ accessToken);
    }

    // 리프레시 토큰 헤더 설정
    public void setHeaderRefreshToken(HttpServletResponse response, String refreshToken) {
        response.setHeader("refreshToken", "bearer "+ refreshToken);
    }
}
