package com.virtusa.examportal.servlet.AuthServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/siteController")
public class SiteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("user");
//        System.out.println(username);
        if (username == null) {
            resp.sendRedirect("loginController");
        } else {
            String role = req.getParameter("role");
            resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            if (role.equals("TEACHER")) {
                req.getRequestDispatcher("/views/teacher/teacherDashboard.jsp").forward(req, resp);
            } else if (role.equals("STUDENT")) {
                req.getRequestDispatcher("/views/student/studentDashboard.jsp").forward(req, resp);
//                resp.sendRedirect("views/studentDashboard.jsp");
            } else if (role.equals("ADMIN")) {
                req.getRequestDispatcher("/views/admin/adminDashboard.jsp").forward(req, resp);
//                resp.sendRedirect("views/adminDashboard.jsp");
            }

        }

    }
}
