package org.example.adressline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
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
                        <h3>Sign Up</h3>
                    </div>
                    <div class="card-body">
                        <form action="/auth">
                            <div class="mb-3">
                                <label for="firstName" class="form-label">First Name</label>
                                <input  name="firstname" type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter your first name" required>
                            </div>
                            <div class="mb-3">
                                <label for="lastName" class="form-label">Last Name</label>
                                <input  name="lastname"  type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter your last name" required>
                            </div>
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone</label>
                                <input  name="phone" type="tel" class="form-control" id="phone" name="phone" placeholder="Enter your phone number" required>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input  name="password" type="password" class="form-control" id="password" name="password" placeholder="Create a password" required>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Sign Up</button>
                        </form>
                    </div>
                    <div class="card-footer text-center">
                         <form action="/login">
                                <small class="text-muted">
                                    Already have an account? <button class="btn btn-secondary">Login</button>
                                </small>
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
