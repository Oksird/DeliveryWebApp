package app.controller.servlets;

import app.model.DAO.ReceiptDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/generateReceipt")
public class GenerateReceiptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderID = req.getParameter("order_id");
        ReceiptDAO.generateReceipt(orderID);
        resp.sendRedirect("/manageOrders");
    }
}
