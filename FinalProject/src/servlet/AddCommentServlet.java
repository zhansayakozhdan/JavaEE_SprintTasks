package servlet;

import db.DbComment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Comment;
import model.User;

import java.io.IOException;

@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("value");
        User user = (User) req.getSession().getAttribute("currentUser");
        Long postId = Long.parseLong(req.getParameter("postId"));

        DbComment.addComment(value, user.getId(), postId);
        resp.sendRedirect("/postDetails?id=" + postId);

    }
}
