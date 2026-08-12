package com.hotelbooking.controller;
import com.hotelbooking.dao.BookingDAO; import com.hotelbooking.model.*; import jakarta.servlet.*; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import java.io.IOException; import java.math.BigDecimal; import java.time.*; import java.util.UUID;
@WebServlet("/book")
public class BookingServlet extends HttpServlet{
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{
  try{User u=(User)r.getSession().getAttribute("user");if(u==null){s.sendRedirect(r.getContextPath()+"/login.jsp");return;}
   LocalDate in=LocalDate.parse(r.getParameter("checkIn")),out=LocalDate.parse(r.getParameter("checkOut"));if(!out.isAfter(in))throw new IllegalArgumentException("Check-out must be after check-in.");
   int nights=(int)java.time.temporal.ChronoUnit.DAYS.between(in,out), rooms=Integer.parseInt(r.getParameter("rooms"));BigDecimal price=new BigDecimal(r.getParameter("price"));
   BigDecimal sub=price.multiply(BigDecimal.valueOf(nights)).multiply(BigDecimal.valueOf(rooms)),tax=sub.multiply(new BigDecimal("0.18")).setScale(2),fee=new BigDecimal("500"),total=sub.add(tax).add(fee);
   Booking b=new Booking();b.setBookingId("INH-"+UUID.randomUUID().toString().substring(0,8).toUpperCase());b.setUserId(u.getId());b.setHotelId(Integer.parseInt(r.getParameter("hotelId")));b.setRoomId(Integer.parseInt(r.getParameter("roomId")));b.setGuestName(r.getParameter("guestName"));b.setGuestEmail(r.getParameter("guestEmail"));b.setGuestPhone(r.getParameter("guestPhone"));b.setCheckIn(in);b.setCheckOut(out);b.setAdults(Integer.parseInt(r.getParameter("adults")));b.setChildren(Integer.parseInt(r.getParameter("children")));b.setRooms(rooms);b.setSubtotal(sub);b.setTax(tax);b.setServiceFee(fee);b.setTotalAmount(total);new BookingDAO().create(b);r.setAttribute("booking",b);r.getRequestDispatcher("/confirmation.jsp").forward(r,s);
  }catch(Exception e){throw new ServletException(e);}
 }
}
