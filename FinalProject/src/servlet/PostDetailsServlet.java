package servlet;

import db.DbComment;
import db.DbManager;
import db.DbPost;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Comment;
import model.Post;
import model.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/postDetails")
public class PostDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User currentUser = (User) req.getSession().getAttribute("currentUser");

        if(currentUser == null){
            resp.sendRedirect("/signin");
            return;
        }

        int role = DbManager.getUserRoleIdByEmail(currentUser.getEmail());
        req.setAttribute("roleId", role);

        Long id = Long.parseLong(req.getParameter("id"));
        Post post = DbPost.getPostById(id);
        req.setAttribute("post", post);

        List<Comment> comments = DbComment.getCommentsByPostId(id);
        req.setAttribute("comments", comments);
        req.getRequestDispatcher("postDetails.jsp").forward(req, resp);
    }
}
