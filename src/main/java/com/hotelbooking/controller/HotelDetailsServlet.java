package com.hotelbooking.controller;
import com.hotelbooking.dao.*; import jakarta.servlet.*; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException;
@WebServlet("/hotel")
public class HotelDetailsServlet extends HttpServlet{
 protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
  try{int id=Integer.parseInt(req.getParameter("id"));req.setAttribute("hotel",new HotelDAO().findById(id));req.setAttribute("images",new HotelImageDAO().findByHotel(id));req.setAttribute("rooms",new RoomDAO().findByHotel(id));req.getRequestDispatcher("/hotel-details.jsp").forward(req,resp);}
  catch(Exception e){throw new ServletException(e);}
 }
}
