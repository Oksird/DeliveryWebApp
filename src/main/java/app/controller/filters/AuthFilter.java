package app.controller.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/profile.jsp","/profile","/logOut", "/createOrder", "/createOrder.jsp", "/receipt","/receipt.jsp"})
public class AuthFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("username") != null);

        if (isLoggedIn){
            chain.doFilter(req, resp);
        }else {
            ((HttpServletResponse)resp).sendRedirect("/logIn");
        }
    }

    public void destroy() {}

}
