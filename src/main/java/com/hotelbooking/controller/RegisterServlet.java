package com.hotelbooking.controller;
import com.hotelbooking.dao.UserDAO; import com.hotelbooking.model.User; import org.mindrot.jbcrypt.BCrypt; import jakarta.servlet.*; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{
  try{UserDAO d=new UserDAO();if(d.findByEmail(r.getParameter("email"))!=null){r.setAttribute("error","Email already registered");r.getRequestDispatcher("/register.jsp").forward(r,s);return;}User u=new User();u.setFullName(r.getParameter("fullName"));u.setEmail(r.getParameter("email"));u.setPhone(r.getParameter("phone"));u.setPasswordHash(BCrypt.hashpw(r.getParameter("password"),BCrypt.gensalt(12)));d.create(u);s.sendRedirect(r.getContextPath()+"/login.jsp");}catch(Exception e){throw new ServletException(e);}
 }
}
