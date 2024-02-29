package servlet;

import db.DbPost;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Post;
import model.PostsCategory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/addPost")
public class AddPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PostsCategory> categories = DbPost.getAllPostsCategories();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("addPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("post_title");
        String content = req.getParameter("post_content");
        Long categoryId = Long.parseLong(req.getParameter("category_id"));

        PostsCategory category = DbPost.getCategoryById(categoryId);
        if (category != null) {
            Post post = new Post(title, content, category);
            DbPost.createPost(post);
            resp.sendRedirect("/addPost?success");
        } else {
            resp.sendRedirect("/addPost?error");
        }

    }
}
