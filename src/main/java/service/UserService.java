package service;

import dao.UserDao;
import entity.User;

public class UserService {
    UserDao userDao=new UserDao();

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            UserDao.insertUser(new User("user"+i,i,i+i+i+"@qq.com"));
        }
    }
}
