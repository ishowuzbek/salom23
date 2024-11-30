package org.example.adressline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regions/delete")
public class DeleteRegionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regionIdStr = req.getParameter("region_id");

            int regionId = Integer.parseInt(regionIdStr);

          DB.REGIONS.removeIf(region -> region.getId() == regionId);

        resp.sendRedirect("/regions");
    }
}
