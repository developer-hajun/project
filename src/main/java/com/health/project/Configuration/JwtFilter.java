package com.health.project.Configuration;

import com.health.project.Service.MemberService;
import com.health.project.util.JwtTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final MemberService memberService;
    private final String secretKey;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authentication =  request.getHeader("Authorization");
        logger.info("authentication : {"+authentication+"}");
        if(authentication == null || !authentication.startsWith("Bearer ")){
            logger.error("authentication이 없습니다");
            filterChain.doFilter(request,response);
            return;
        }
        String token = authentication.split(" ")[1];
        String id= JwtTokenUtil.getId(token,secretKey);
        logger.info("id="+id);
        if(JwtTokenUtil.isExpired(token,secretKey)){
            logger.error("authentication이 만료");
            filterChain.doFilter(request,response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(id,null, List.of(new SimpleGrantedAuthority("Member")));
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);
    }
}
