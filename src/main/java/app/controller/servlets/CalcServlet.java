package app.controller.servlets;

import app.model.comands.Calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("price", Calc.calculateCost(
                Integer.parseInt(req.getParameter("isInCityDel")),
                Integer.parseInt(req.getParameter("size")),
                Integer.parseInt(req.getParameter("weight"))
        ));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("mainPage.jsp");
        requestDispatcher.forward(req, resp);
    }

}
