package com.oleksandramala.elective.controllers;

import com.oleksandramala.elective.DAO.LoginDAO;
import com.oleksandramala.elective.Utils.DBManager;
import com.oleksandramala.elective.entities.Login;
import com.oleksandramala.elective.entities.Role;
import com.oleksandramala.elective.entities.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDAO loginDAO;

    public void init(){
        loginDAO = new LoginDAO();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        authenticate(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException{
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

       // DBManager dbManager = DBManager.getInstance();
        User user = loginDAO.getUser(username, password);
       // Role role = user.getRole();

        HttpSession session = request.getSession();
        //session.setAttribute("id", user.getId());
        try {
            if (loginDAO.validate(login)){

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/main.jsp");
                dispatcher.forward(request,response);
            }else{
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException | ServletException e) {
            e.printStackTrace();
        }


    }
}
