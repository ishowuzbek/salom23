package org.example.adressline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/countries")
public class CountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String countryName = req.getParameter("country_name");

        if (countryName != null && !countryName.isEmpty()) {
            DB.COUNTRIES.add(new Country(countryName));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Country country : DB.COUNTRIES) {
            stringBuilder.append("""
                <li class="list-group-item">
                    <span>%s</span>
                    <div>
                        <form action="/regions">
                            <button name="country_id" value="%d" class="btn btn-sm btn-primary me-1">Go</button>
                        </form>
                        <form action="/country/delete" method="post">
                            <input type="hidden" name="country_id" value="%d">
                            <button type="submit" class="btn btn-sm btn-danger">X</button>
                        </form>
                    </div>
                </li>
                """.formatted(country.getName(), country.getId(), country.getId()));
        }


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Countries</title>
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
                   <form action="/countries/add">
                       <div class="card-header d-flex justify-content-between align-items-center bg-primary text-white">
                           <h5 class="m-0">Countries</h5>
                           <button class="btn btn-light btn-sm"><strong>+</strong></button>
                       </div>
                   </form>
                   <ul class="list-group list-group-flush">
                       %s
                   </ul>
                </div>
                </body>
                </html>
                """.formatted(stringBuilder.toString()));
    }
}
