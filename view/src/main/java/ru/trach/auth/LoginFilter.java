package ru.trach.auth;

import ru.trach.auth.beans.AuthBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/addbook.xhtml")
public class LoginFilter implements Filter {
    @Inject
    private AuthBean authBean;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(authBean.isLoggedIn()){
            chain.doFilter(request, response);
            return;
        }

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.xhtml");

    }

    @Override
    public void destroy() {

    }
}
