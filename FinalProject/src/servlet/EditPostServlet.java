package servlet;

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

@WebServlet("/editPost")
public class EditPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("post_title");
        String content = req.getParameter("post_content");
        Long categoryId = Long.parseLong(req.getParameter("category_id"));

        String redirect = "/";

        PostsCategory category = DbPost.getCategoryById(categoryId);
        if (category != null) {
            Post post = DbPost.getPostById(id);

            if (post != null) {
                post.setTitle(title);
                post.setContent(content);
                post.setCategory(category);

                if (DbPost.editPost(post)) {
                    redirect = "/editPost?id=" + id + "&success";
                } else {
                    redirect = "/editPost?id=" + id + "&error";
                }
            }
        }
        resp.sendRedirect(redirect);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        if (currentUser == null) {
            resp.sendRedirect("/signin");
            return;
        }


        Long id = Long.parseLong(req.getParameter("id"));

        Post post = DbPost.getPostById(id);

        if (post != null) {
            req.setAttribute("post", post);

            List<PostsCategory> categories = DbPost.getAllPostsCategories();
            req.setAttribute("categories", categories);

            req.getRequestDispatcher("/editPost.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }

}
