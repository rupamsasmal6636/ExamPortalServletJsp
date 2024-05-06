package com.virtusa.examportal.servlet.AuthServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.examportal.dao.UserDAO;
import com.virtusa.examportal.model.User;

@WebServlet("/loginController")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "login":
                req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
                break;
            case "register":
                req.getRequestDispatcher("/views/auth/register.jsp").forward(req,resp);
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "loginSubmit":
                authenticate(req, resp);
                break;
            default:
                break;
        }

    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = (User)userDAO.authenticateUser(username, password);
        if (user != null) {
            String userFetchedFromDb = user.getUsername();
            request.getSession().invalidate();
            HttpSession session = request.getSession();
            session.setAttribute("user", userFetchedFromDb);
            session.setMaxInactiveInterval(500);
            response.sendRedirect("siteController?role=" + user.getRole());

        } else {
            response.sendRedirect(request.getContextPath()+"/views/alert/signFailedAlert.jsp");
//            response.sendRedirect(request.getContextPath()+"/loginController?action=login");
        }

    }
}
