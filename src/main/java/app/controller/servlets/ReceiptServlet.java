package app.controller.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/receipt")
public class ReceiptServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String receiptText = request.getParameter("receiptText");
        String order_id = request.getParameter("order_id");
        String orderAuthorID = request.getParameter("orderAuthorID");
        request.setAttribute("receiptText", receiptText);
        request.setAttribute("order_id", order_id);
        request.setAttribute("orderAuthorID", orderAuthorID);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("receipt.jsp");
        requestDispatcher.forward(request, response);
    }
}
