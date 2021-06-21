package dao;

import entity.User;
import utils.MysqlConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static int insertUser(User user){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection= MysqlConnection.getInstance().getConnection();
            preparedStatement=connection.prepareStatement("insert into my_user(username,age,email)values (?,?,?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setInt(2,user.getAge());
            preparedStatement.setString(3,user.getEmail());
            return preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
        return 0;
    }
    public List<User> findClazzByPage(int start, int size) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        List<User> clazzList = new ArrayList<>();

        try {
            connection = MysqlConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM my_user limit ?,?;");
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, size);
            set = preparedStatement.executeQuery();

            while (set != null && set.next()) {
                User user = new User();
                user.setId(set.getInt(1));
                user.setName(set.getString(2));
                user.setAge(set.getInt(3));
                user.setEmail(set.getString(4));
                clazzList.add(user);
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return clazzList;
    }
}
