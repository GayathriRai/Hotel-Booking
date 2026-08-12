package com.hotelbooking.controller;
import com.hotelbooking.dao.BookingDAO; import com.hotelbooking.model.User; import jakarta.servlet.*; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException;
@WebServlet("/cancel-booking")
public class CancelBookingServlet extends HttpServlet{protected void doPost(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{try{User u=(User)r.getSession().getAttribute("user");if(u==null){s.sendRedirect(r.getContextPath()+"/login.jsp");return;}new BookingDAO().cancel(r.getParameter("bookingId"),u.getId());s.sendRedirect(r.getContextPath()+"/my-bookings");}catch(Exception e){throw new ServletException(e);}}}
