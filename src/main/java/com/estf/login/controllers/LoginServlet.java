package com.estf.login.controllers;

import com.estf.login.buisness.DefaultServices;
import com.estf.login.buisness.Service;
import com.estf.login.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = DefaultServices.getInstance();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(email.equals("") || password.equals("")){
            request.setAttribute("message", "All fields are required");
            doGet(request,response);
        }

        User user = new User(email,password);
        for (User user1:service.getUsers()) {
            if(user1.getEmail().equals(user.getEmail())){
                if(user1.getPassword().equals(user.getPassword())){
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("Auth", true);
                    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Expires", "0");
                    response.setStatus(200);
                    response.sendRedirect("home");
                    return;
                }
                request.setAttribute("message" , "Password Incorrect");
                doGet(request,response);
                return;
            }
        }

        request.setAttribute("message" , "User not Found ");
        doGet(request,response);

    }
}
