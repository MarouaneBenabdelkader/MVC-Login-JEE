package com.estf.login.controllers;

import com.estf.login.models.User;
import com.estf.login.buisness.DefaultServices;
import com.estf.login.buisness.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = DefaultServices.getInstance();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(email.equals("") || password.equals("")){
            request.setAttribute("message", "All fields are required");
            doGet(request,response);
            return;
        }
        User user = service.addUser(new User(email,password));
        if(user == null){
            request.setAttribute("message", "User already exist");
            doGet(request,response);
            return;
        }
        System.out.println("User Inserted ");
        response.setStatus(200);
        response.sendRedirect("login");



    }
}
