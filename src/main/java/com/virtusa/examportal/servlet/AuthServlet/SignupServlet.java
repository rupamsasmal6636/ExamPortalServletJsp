package com.virtusa.examportal.servlet.AuthServlet;

import com.virtusa.examportal.dao.UserDAO;
import com.virtusa.examportal.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username= req.getParameter("username");
        String password= req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String role= req.getParameter("role");
//        System.out.println(name);

        if (!password.equals(confirmPassword)) {

            resp.sendRedirect("views/alert/regFailedAlert.jsp");
            return;
        }
        UserDAO userDAO = new UserDAO();
        if (userDAO.getUserByUsername(username) != null) {
            resp.sendRedirect("views/alert/regFailedAlert.jsp");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        boolean status = userDAO.createUser(user);
        if(status==true){
//            resp.sendRedirect("views/login.jsp?status=success");
            resp.sendRedirect("views/alert/regSuccessAlert.jsp");
        } else {
            resp.sendRedirect("views/alert/regFailedAlert.jsp");
        }
    }
}
