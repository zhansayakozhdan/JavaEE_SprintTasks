package servlet;

import db.DbManager;
import db.DbPost;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Post;
import model.PostsCategory;
import model.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/edit")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        if (currentUser != null) {
            req.setAttribute("user", currentUser);
            req.getRequestDispatcher("editProfile.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/signin.jsp");
        }
//        String email = req.getParameter("user_email");
//
//        User user = DbManager.getUserByEmail(email);

//        if(user != null){
//            req.setAttribute("user", user);
//            req.getRequestDispatcher("/editProfile.jsp").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("/").forward(req, resp);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("user_email");
        String newFullName = req.getParameter("full_name");
        String newPassword = req.getParameter("password");

        String redirect = "/";

        User user = DbManager.getUserByEmail(email);
        if(user != null){

            user.setFullName(newFullName);
            user.setPassword(newPassword);

            if(DbManager.editProfile(user)){
                redirect = "/edit?" + "&success";
                req.getSession().setAttribute("currentUser", user);
            } else {
                redirect = "/edit?" + "&error";
            }
        }

        resp.sendRedirect(redirect);
    }
}
