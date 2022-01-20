package app.controller.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/manageOrders", "/manageOrders.jsp"})
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        boolean isManager = (session != null && "manager".equals(session.getAttribute("role")));

        if (isManager){
            chain.doFilter(request, response);
        }else {
            ((HttpServletResponse)response).sendRedirect("/profile");
        }
    }

    @Override
    public void destroy() {}
}
