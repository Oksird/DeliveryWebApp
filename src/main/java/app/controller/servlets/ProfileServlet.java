package app.controller.servlets;

import app.model.DAO.GetOrderListDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("id");
        req.setAttribute("OrderSetOfCurrentUser", new GetOrderListDAO().getUserOrderList(userId));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("profile.jsp");
        requestDispatcher.forward(req, resp);
    }
}
