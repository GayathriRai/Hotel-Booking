package com.hotelbooking.controller;
import com.hotelbooking.dao.HotelDAO; import jakarta.servlet.*; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException;
@WebServlet("/hotels")
public class HotelSearchServlet extends HttpServlet{
 protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
  try{req.setAttribute("hotels",new HotelDAO().findAll(req.getParameter("destination")));req.getRequestDispatcher("/hotels.jsp").forward(req,resp);}
  catch(Exception e){throw new ServletException(e);}
 }
}
