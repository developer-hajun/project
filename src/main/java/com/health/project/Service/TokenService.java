package com.health.project.Service;


import com.health.project.Entity.RefreshToken;
import com.health.project.Repository.token.RefreshTokenRepository;
import com.health.project.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TokenService {
    private final RefreshTokenRepository tokenRepository;
    private final JwtTokenUtil jwtTokenUtil;
    public void save(String token){
        RefreshToken refreshToken = new RefreshToken(token);
        tokenRepository.save(refreshToken);
    }

    @Transactional
    public void deleteToken(String refreshToken) {
        Optional<RefreshToken> deleteToken = tokenRepository.findByToken(refreshToken);
        deleteToken.ifPresent(tokenRepository::delete);
        //access token은 브라우저에서 삭제해야함
    }

    public String GetTokenId(String token){
        return jwtTokenUtil.getclaims(token).getSubject();
    }
}
