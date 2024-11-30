package org.example.adressline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/countries/add")
public class AddCountryServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Sign Up</title>
                  <!-- Bootstrap CSS -->
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
                    <h3>Add Country</h3>
                  </div>
                  <div class="card-body">
                    <form action="/countries">
                      <div class="mb-3">
                        <label for="Country name" class="form-label">Country Name</label>
                        <input type="text" class="form-control" id="Country name" name="country_name" placeholder="Enter the name" required>
                        <button class="btn btn-info ">add</button>
                      </div>
                    </form>
                  </div>
                </div>
                
                <!-- Bootstrap JS (Optional) -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
                </body>
                </html>
                
                """);
    }
}
