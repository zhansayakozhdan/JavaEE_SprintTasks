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
import model.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/posts")
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //считываем из сессии
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            resp.sendRedirect("/signin");
            return;
        }

        int role = DbManager.getUserRoleIdByEmail(currentUser.getEmail());
        req.setAttribute("roleId", role);

        List<Post> posts = DbPost.getAllPosts();
        req.setAttribute("novosti", posts);
        req.getRequestDispatcher("posts.jsp").forward(req, resp);
    }
}
