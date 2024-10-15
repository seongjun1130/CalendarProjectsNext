package com.sparta.calendarprojectsnext.domain.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Order(0)
@Component
public class AuthenticationExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(req, res);
        } catch (CustomException e) {
            if (!res.isCommitted()) {
                res.setStatus(e.getErrorCode().getStatus());
                res.setContentType("application/json");
                res.setCharacterEncoding("UTF-8");
                res.getWriter().write(e.getErrorCode().toString());
            }
        }
    }
}
