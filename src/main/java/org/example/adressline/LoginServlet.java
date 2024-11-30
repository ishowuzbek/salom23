package org.example.adressline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Login Page</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
                </head>
                <body class="bg-light">
                <div class="container">
                    <div class="row justify-content-center align-items-center vh-100">
                        <div class="col-md-4">
                            <div class="card shadow-sm">
                                <div class="card-header text-center bg-primary text-white">
                                    <h3>Login</h3>
                                </div>
                                <div class="card-body">
                                    <form action="/check">
                                        <div class="mb-3">
                                            <label for="phone" class="form-label">Phone number</label>
                                            <input name="phone" type="phone" class="form-control" id="phone" placeholder="Enter your phone">
                                        </div>
                                        <div class="mb-3">
                                            <label for="password" class="form-label">Password</label>
                                            <input name="password" type="password" class="form-control" id="password" placeholder="Enter your password">
                                        </div>
                                        <div class="mb-3 form-check">
                                            <input type="checkbox" class="form-check-input" id="rememberMe">
                                            <label class="form-check-label" for="rememberMe">Remember me</label>
                                        </div>
                                        <button type="submit" class="btn btn-primary w-100">Login</button>
                                    </form>
                                </div>
                                <div class="card-footer text-center">
                                <form action="/signup">
                                    <small class="text-muted">
                                        Don't have an account?  <button class="btn btn-secondary">Sign Up</button>
                                    </small>
                                 </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- Bootstrap JS (Optional) -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
                </body>
                </html>
                """);
    }
}
