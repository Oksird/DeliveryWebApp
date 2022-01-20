package app.controller.servlets;

import app.model.DAO.GetOrderListDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manageOrders")
public class manageOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("AllOrders", new GetOrderListDAO().getAllUsersOrderList());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("manageOrders.jsp");
        requestDispatcher.forward(req, resp);
    }
}
