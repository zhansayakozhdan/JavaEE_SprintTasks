package db;

import model.Comment;
import model.Post;
import model.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DbComment {
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

    public static List<Comment> getCommentsByPostId(Long postId){
        List<Comment> comments = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT c.*, p.title, p.content, p.created_at AS postCreatedAt, u.email " +
                            "FROM COMMENTS c " +
                            "INNER JOIN POSTS p ON p.id = c.post_id " +
                            "INNER JOIN USERS u ON u.id = c.user_id " +
                            "WHERE c.post_id = ?"
            );

            statement.setLong(1, postId);
           ResultSet result =  statement.executeQuery();
           while(result.next()){
               Comment comment = new Comment();
               comment.setId(result.getLong("id"));
               comment.setValue(result.getString("value"));
               comment.setPostedAt(result.getObject("posted_at", LocalDateTime.class));

               User user = new User();
               user.setId(result.getLong("user_id"));
               user.setEmail(result.getString("email"));
               comment.setUser(user);

               Post post = new Post();
               post.setId(result.getLong("post_id"));
               post.setTitle(result.getString("title"));
               post.setContent(result.getString("content"));
               post.setCreatedAt(result.getObject("postCreatedAt", LocalDateTime.class));
               comment.setPost(post);

               comments.add(comment);
           }
           statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return comments;
    }

    public static void addComment(String value, Long userId, Long postId){
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO COMMENTS (value, user_id, post_id, posted_at) " +
                            "VALUES (?, ?, ?, now())"
            );
            statement.setString(1, value);
            statement.setLong(2, userId);
            statement.setLong(3, postId);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
