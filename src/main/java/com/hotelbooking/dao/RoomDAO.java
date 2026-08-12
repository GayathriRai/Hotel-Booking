package com.hotelbooking.dao;
import com.hotelbooking.model.Room; import com.hotelbooking.util.DBConnection; import java.sql.*; import java.util.*;
public class RoomDAO {
 public List<Room> findByHotel(int hotelId)throws SQLException{
  List<Room>x=new ArrayList<>();String s="SELECT * FROM rooms WHERE hotel_id=? ORDER BY price_per_night";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(s)){p.setInt(1,hotelId);try(ResultSet r=p.executeQuery()){while(r.next()){Room a=new Room();a.setId(r.getInt("id"));a.setHotelId(hotelId);a.setRoomName(r.getString("room_name"));a.setDescription(r.getString("description"));a.setMaxGuests(r.getInt("max_guests"));a.setBedType(r.getString("bed_type"));a.setPricePerNight(r.getBigDecimal("price_per_night"));a.setAvailableRooms(r.getInt("available_rooms"));x.add(a);}}}return x;
 }
}
