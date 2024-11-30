package org.example.adressline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/check")
public class CheckLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        for (User user : DB.USERS) {
           if (user.getPhone().equals(phone) && user.getPassword().equals(password)) {
               if (!resp.isCommitted()) {
                   resp.sendRedirect("/countries");
                   return;
               }
           }
        }
        resp.sendRedirect("/login");
    }
}
