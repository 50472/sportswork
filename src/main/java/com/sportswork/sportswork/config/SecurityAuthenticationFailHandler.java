package com.sportswork.sportswork.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("securityAuthenticationFailHandler")
public class SecurityAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

//    @Value("${security.user.failureUrl}")
    @Value("/security")
    private String failureUrl;// 权限认证失败地址

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        /* 跳转到指定页面 */
//        String redirectUrl = "/login-error?message=" + URLEncoder.encode(exception.getMessage(),"UTF-8");
        new DefaultRedirectStrategy().sendRedirect(request, response, "/register?error");
    }
}