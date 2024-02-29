package db;

import model.Post;
import model.User;

import java.sql.*;
import java.util.Objects;

public class DbManager {
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

    public static User getUserByEmail(String email){
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM USERS " +
                            "WHERE EMAIL = ?"
            );
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                user = new User();
                user.setId(result.getLong("id"));
                user.setEmail(result.getString("email"));
                user.setFullName(result.getString("full_name"));
                user.setPassword(result.getString("password"));
                user.setRoleId(result.getInt(1));
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public static boolean createUser(User user, String rePassword){
        int rows = 0;
        User currentUser = getUserByEmail(user.getEmail());
        if(currentUser != null){
            return false;
        }

        if(!Objects.equals(user.getPassword(), rePassword)){
            return false;
        }
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO USERS(full_name, email, password, role_id) " +
                            "VALUES(?, ?, ?, ?)"
            );
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRoleId());
            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static User authorization(String email, String password){
        User user = getUserByEmail(email);

        if(user == null){
            return null;
        }
        if(!Objects.equals(user.getPassword(), password)){
            return null;
        }
        return user;
    }

    public static boolean editProfile(User user) {
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE USERS SET FULL_NAME = ?, PASSWORD = ? " +
                            "WHERE ID = ?"
            );
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getPassword());
            statement.setLong(3, user.getId());

            rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows>0;
    }

    public static Integer getUserRoleIdByEmail(String email){
        Integer roleId = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM USERS " +
                            "WHERE EMAIL = ?"
            );
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                roleId = result.getInt("role_id");
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }


        return roleId;
    }
}
