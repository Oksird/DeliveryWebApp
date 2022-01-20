package app.controller.servlets;

import app.model.DAO.CreateOrderDAO;
import app.model.comands.PrepareOrder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createOrder")
public class CreateOrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("createOrder.jsp");
        requestDispatcher.forward(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uId = (int) req.getSession().getAttribute("id");
        new CreateOrderDAO().createOrder(new PrepareOrder(req, uId).getPreparedOrder());
        resp.sendRedirect("/profile");
    }
}
