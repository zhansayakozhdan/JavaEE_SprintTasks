package servlet;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet("/login")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");
        boolean userExists = DBManager.auth(email, password);
        if(userExists){
            User user = DBManager.getUserByEmail(email);
            req.setAttribute("user", user);
            req.getRequestDispatcher("profile.jsp").forward(req, resp);
           // resp.sendRedirect("profile.jsp");
        } else {
            req.setAttribute("errorMessage", "Неверный email или пароль");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
//        req.setAttribute("message", userExists);
//        req.getRequestDispatcher("login.jsp").forward(req, resp);
//        resp.sendRedirect("profile.jsp");
    }
}
