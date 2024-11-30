package org.example.adressline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/regions")
public class RegionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regionName = req.getParameter("region_name");
        String countryIdi = req.getParameter("country_id");
        System.out.println("salom");

        try {
            int countryID = Integer.parseInt(countryIdi);

            if (regionName != null && !regionName.isEmpty()) {
                DB.REGIONS.add(new Region(regionName, countryID));
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Region region : DB.REGIONS) {
                if (region.getCountryId() == countryID) {
                    stringBuilder.append("""
                        <li class="list-group-item">
                            <span>%s</span>
                            <div>
                                <button class="btn btn-sm btn-primary me-1">Go</button>
                                <form action="/regions/delete" method="post">
                                    <input type="hidden" name="region_id" value="%d">
                                    <button type="submit" class="btn btn-sm btn-danger">X</button>
                                </form>
                            </div>
                        </li>
                        """.formatted(region.getName(), region.getId()));
                }
            }
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("""
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                      <meta charset="UTF-8">
                      <meta name="viewport" content="width=device-width, initial-scale=1.0">
                      <title>Regions</title>
                      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
                      <style>
                        .card {
                          width: 400px;
                          border-radius: 10px;
                        }
                        .list-group-item {
                          display: flex;
                          justify-content: space-between;
                          align-items: center;
                        }
                      </style>
                    </head>
                    <body class="bg-light d-flex justify-content-center align-items-center vh-100">
                    <div class="card shadow-sm">
                      <form action="/regions_add">
                        <div class="card-header d-flex justify-content-between align-items-center bg-primary text-white">
                          <h5 class="m-0">Regions</h5>
                          <button name="countId" value="%d" class="btn btn-light btn-sm"><strong>+</strong></button>
                        </div>
                      </form>
                      <ul class="list-group list-group-flush">
                        %s
                      </ul>
                    </div>
                    </body>
                    </html>
                    """.formatted(countryID, stringBuilder.toString()));

        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid country ID");
        }
    }
}
