package org.example.adressline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/regions_add")
public class AddRegionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String countryIdcha = req.getParameter("countId");

        int countryId = 0;
        try {
            countryId = Integer.parseInt(countryIdcha);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid country ID");
            return;
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Add Region</title>
                  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
                  <style>
                    .card {
                      width: 400px;
                      border-radius: 10px;
                    }
                  </style>
                </head>
                <body class="bg-light d-flex justify-content-center align-items-center vh-100">
                <div class="card shadow-sm">
                  <div class="card-header text-center bg-primary text-white">
                    <h3>Add Region</h3>
                  </div>
                  <div class="card-body">
                    <form action="/regions">
                      <div class="mb-3">
                        <label for="regionName" class="form-label">Region Name</label>
                        <input type="text" class="form-control" id="regionName" name="region_name" placeholder="Enter the name" required>
                        <button type="submit" name="country_id" value="%d" class="btn btn-info">Add</button>
                      </div>
                    </form>
                  </div>
                </div>
                </body>
                </html>
                """.formatted(countryId));
    }
}
