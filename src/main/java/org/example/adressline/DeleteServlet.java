package org.example.adressline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/country/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String countryId = req.getParameter("country_id");
            int deleteId = Integer.parseInt(countryId);

            DB.COUNTRIES.removeIf(country -> country.getId() == deleteId);

        resp.sendRedirect("/countries");
        System.out.println("salom");
    }
}
