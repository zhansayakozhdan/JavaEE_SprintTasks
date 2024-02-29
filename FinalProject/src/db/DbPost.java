package db;

import model.Post;
import model.PostsCategory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DbPost {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/FPZK",
                    "postgres",
                    "postgres"
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT p.id, p.title, p.content, p.created_at, p.category_id, " +
                            "pc.name FROM POSTS p " +
                            "INNER JOIN POSTS_CATEGORIES pc ON p.category_id = pc.id " +
                            "ORDER BY p.created_at DESC "
            );
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Post post = new Post();
                post.setId(result.getLong("id"));
                post.setTitle(result.getString("title"));
                post.setContent(result.getString("content"));
                post.setCreatedAt(result.getObject("created_at", LocalDateTime.class));

                PostsCategory category = new PostsCategory();
                category.setId(result.getLong("category_id"));
                category.setCategoryName(result.getString("name"));

                post.setCategory(category);
                posts.add(post);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return posts;
    }

    public static Post getPostById(Long id){
        Post post = null;
        try {
            var statement = connection.prepareStatement(
                    "SELECT p.id, p.title, p.content, p.created_at, p.category_id, " +
                            "pc.name FROM POSTS p " +
                            "INNER JOIN POSTS_CATEGORIES pc ON p.category_id = pc.id " +
                            "WHERE p.id = ? "
            );
            statement.setLong(1, id);
            var result = statement.executeQuery();
            if(result.next()){
                post = new Post();
                post.setId(result.getLong("id"));
                post.setTitle(result.getString("title"));
                post.setContent(result.getString("content"));
                post.setCreatedAt(result.getObject("created_at", LocalDateTime.class));

                PostsCategory category = new PostsCategory();
                category.setId(result.getLong("category_id"));
                category.setCategoryName(result.getString("name"));

                post.setCategory(category);
            }
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return post;
    }

    public static void createPost(Post post){
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO POSTS(title, content, category_id, created_at) " +
                            "VALUES (?, ?, ?, now())"
            );
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getContent());
            statement.setLong(3, post.getCategory().getId());

            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static List<PostsCategory> getAllPostsCategories() {
        List<PostsCategory> categories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM POSTS_CATEGORIES"
            );
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                PostsCategory category = new PostsCategory();
                category.setId(result.getLong("id"));
                category.setCategoryName(result.getString("name"));

                categories.add(category);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

    public static PostsCategory getCategoryById(Long id){
        PostsCategory category = null;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM POSTS_CATEGORIES " +
                            "WHERE id = ? LIMIT 1"
            );
            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();
            if(result.next()){
                category = new PostsCategory();
                category.setId(result.getLong("id"));
                category.setCategoryName(result.getString("name"));
            }
            statement.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return category;
    }

    public static boolean editPost(Post post) {
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE POSTS SET TITLE = ?, CONTENT = ?, CATEGORY_ID = ? " +
                            "WHERE ID = ?"
            );
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getContent());
            statement.setLong(3, post.getCategory().getId());
            statement.setLong(4, post.getId());

            rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows>0;
    }

    public static boolean deletePost(Post post){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM POSTS WHERE ID = ?"
            );
            statement.setLong(1, post.getId());


            rows = statement.executeUpdate();
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows>0;
    }
}
