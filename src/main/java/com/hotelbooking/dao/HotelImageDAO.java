package com.hotelbooking.dao;
import com.hotelbooking.model.HotelImage; import com.hotelbooking.util.DBConnection; import java.sql.*; import java.util.*;
public class HotelImageDAO {
 public List<HotelImage> findByHotel(int hotelId)throws SQLException{
  List<HotelImage> x=new ArrayList<>(); String s="SELECT * FROM hotel_images WHERE hotel_id=? ORDER BY image_order";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(s)){p.setInt(1,hotelId);try(ResultSet r=p.executeQuery()){while(r.next()){HotelImage i=new HotelImage();i.setId(r.getInt("id"));i.setHotelId(hotelId);i.setImageOrder(r.getInt("image_order"));i.setImageUrl(r.getString("image_url"));x.add(i);}}}return x;
 }
}
