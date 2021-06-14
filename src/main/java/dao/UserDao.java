package dao;

import entity.User;
import utils.MysqlConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
