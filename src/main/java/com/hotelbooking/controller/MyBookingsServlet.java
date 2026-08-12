package com.hotelbooking.controller;
import com.hotelbooking.dao.BookingDAO; import com.hotelbooking.model.User; import jakarta.servlet.*; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException;
@WebServlet("/my-bookings")
public class MyBookingsServlet extends HttpServlet{protected void doGet(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{try{User u=(User)r.getSession().getAttribute("user");if(u==null){s.sendRedirect(r.getContextPath()+"/login.jsp");return;}r.setAttribute("bookings",new BookingDAO().findByUser(u.getId()));r.getRequestDispatcher("/my-bookings.jsp").forward(r,s);}catch(Exception e){throw new ServletException(e);}}}
