package app.controller.servlets;

import app.model.DAO.SighInDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sighIn")
public class SighInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("sighIn.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        if(!SighInDAO.isUserNameAvailable(username)){
            req.setAttribute("message","<br><label>User with this username already exist</label>");
            req.getRequestDispatcher("sighIn.jsp").forward(req, resp);

        }else {
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String phoneNumber = req.getParameter("phone");

            SighInDAO.addUserToDB(username, password, email, phoneNumber);
            req.getRequestDispatcher("/logIn").forward(req, resp);
            out.print("<br><label>Your registration is complete, please log in</label>");
        }
        out.close();

    }
}
