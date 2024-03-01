package servlet;

import db.DbPost;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Post;

import java.io.IOException;

@WebServlet("/deletePost")
public class DeletePostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Post post = DbPost.getPostById(id);

        if (post != null) {
            if (DbPost.deletePost(post)) {
                resp.sendRedirect("/");
            } else {
                resp.sendRedirect("/editPost?id=" + id + "&error");
            }
        } else {
            resp.sendRedirect("/");
        }
    }
}
