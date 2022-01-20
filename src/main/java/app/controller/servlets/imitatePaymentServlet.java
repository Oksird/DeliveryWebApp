package app.controller.servlets;

import app.model.DAO.ReceiptDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/imitatePayment")
public class imitatePaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReceiptDAO.imitatePayment(request.getParameter("order_id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profile");
        requestDispatcher.forward(request, response);
    }
}
