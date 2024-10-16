package com.sparta.calendarprojectsnext.domain.filter;

import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import com.sparta.calendarprojectsnext.domain.jwt.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.INVALID_TOKEN;
import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.TOKEN_NOT_FOUND;

@Slf4j(topic = "AuthFilter")
@Component
@Order(2)
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        if (isFilterApplicable(req)) {
            chain.doFilter(req, res);
        }
        String tokenValue = jwtUtil.getTokenFromRequest(req);
        if (!StringUtils.hasText(tokenValue)) {
            throw new CustomException(TOKEN_NOT_FOUND);
        }
        String accessToken = jwtUtil.substringToken(tokenValue);
        if (!jwtUtil.validateToken(accessToken)) {
            throw new CustomException(INVALID_TOKEN);
        }
        chain.doFilter(req, res);
    }

    private boolean isFilterApplicable(HttpServletRequest req) {
        String path = req.getRequestURI();
        return path.startsWith("/user/registration") || path.startsWith("/user/login") || path.startsWith("/api");
    }
}
