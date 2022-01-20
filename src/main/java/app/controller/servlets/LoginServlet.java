package app.controller.servlets;

import app.model.DAO.LoginDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logIn")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isAuthAlready  = req.getSession() != null && req.getSession().getAttribute("username") != null;
        String redirect = isAuthAlready ? "/profile" : "logIn.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(redirect);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();

            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if (LoginDAO.validate(username, password)) {
                HttpSession session = req.getSession();
                LoginDAO.configureSession(username, password, session);
                resp.sendRedirect("/profile");
            }
            else {
                req.getRequestDispatcher("logIn.jsp").include(req, resp);
                out.print("<br><label>Incorrect username or password</label>");
            }
            out.close();

    }
}
