package com.hotelbooking.model;
import java.math.BigDecimal;
import java.time.LocalDate;
public class Booking {
    private int id,userId,hotelId,roomId,adults,children,rooms;
    private String bookingId,guestName,guestEmail,guestPhone,status,hotelName,roomName;
    private LocalDate checkIn,checkOut; private BigDecimal subtotal,tax,serviceFee,totalAmount;
    public int getId(){return id;} public void setId(int v){id=v;}
    public int getUserId(){return userId;} public void setUserId(int v){userId=v;}
    public int getHotelId(){return hotelId;} public void setHotelId(int v){hotelId=v;}
    public int getRoomId(){return roomId;} public void setRoomId(int v){roomId=v;}
    public int getAdults(){return adults;} public void setAdults(int v){adults=v;}
    public int getChildren(){return children;} public void setChildren(int v){children=v;}
    public int getRooms(){return rooms;} public void setRooms(int v){rooms=v;}
    public String getBookingId(){return bookingId;} public void setBookingId(String v){bookingId=v;}
    public String getGuestName(){return guestName;} public void setGuestName(String v){guestName=v;}
    public String getGuestEmail(){return guestEmail;} public void setGuestEmail(String v){guestEmail=v;}
    public String getGuestPhone(){return guestPhone;} public void setGuestPhone(String v){guestPhone=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public String getHotelName(){return hotelName;} public void setHotelName(String v){hotelName=v;}
    public String getRoomName(){return roomName;} public void setRoomName(String v){roomName=v;}
    public LocalDate getCheckIn(){return checkIn;} public void setCheckIn(LocalDate v){checkIn=v;}
    public LocalDate getCheckOut(){return checkOut;} public void setCheckOut(LocalDate v){checkOut=v;}
    public BigDecimal getSubtotal(){return subtotal;} public void setSubtotal(BigDecimal v){subtotal=v;}
    public BigDecimal getTax(){return tax;} public void setTax(BigDecimal v){tax=v;}
    public BigDecimal getServiceFee(){return serviceFee;} public void setServiceFee(BigDecimal v){serviceFee=v;}
    public BigDecimal getTotalAmount(){return totalAmount;} public void setTotalAmount(BigDecimal v){totalAmount=v;}
}
