package service;

import dao.UserDao;
import entity.User;

import java.util.List;

public class UserService {
    UserDao userDao=new UserDao();

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            UserDao.insertUser(new User("user"+i,i,i+i+i+"@qq.com"));
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    public List<User> findClazzByPage(int start, int size) {
        return userDao.findClazzByPage(start, size);
    }
}

