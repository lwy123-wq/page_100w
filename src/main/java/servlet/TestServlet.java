package servlet;

import entity.User;
import service.UserService;
import utils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserService();
        int start = Integer.parseInt(req.getParameter("start"));
        int size = Integer.parseInt(req.getParameter("size"));
        List<User> userList = userService.findClazzByPage(start * size, size);
        ResponseUtil.returnWrapper(resp, userList);
    }
}
