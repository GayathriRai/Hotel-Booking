package com.hotelbooking.controller;
import com.hotelbooking.dao.UserDAO; import com.hotelbooking.model.User; import org.mindrot.jbcrypt.BCrypt; import jakarta.servlet.*; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{
  try{User u=new UserDAO().findByEmail(r.getParameter("email"));if(u!=null&&BCrypt.checkpw(r.getParameter("password"),u.getPasswordHash())){r.getSession().setAttribute("user",u);s.sendRedirect(r.getContextPath()+"/");}else{r.setAttribute("error","Invalid email or password");r.getRequestDispatcher("/login.jsp").forward(r,s);}}catch(Exception e){throw new ServletException(e);}
 }
}
