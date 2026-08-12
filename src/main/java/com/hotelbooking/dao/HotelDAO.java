package com.hotelbooking.dao;
import com.hotelbooking.model.Hotel;
import com.hotelbooking.util.DBConnection;
import java.sql.*; import java.util.*;
public class HotelDAO {
    private Hotel map(ResultSet r) throws SQLException {
        Hotel h=new Hotel(); h.setId(r.getInt("id")); h.setName(r.getString("name")); h.setCity(r.getString("city"));
        h.setState(r.getString("state")); h.setAddress(r.getString("address")); h.setDescription(r.getString("description"));
        h.setStarRating(r.getDouble("star_rating")); h.setGuestRating(r.getDouble("guest_rating")); h.setReviewCount(r.getInt("review_count"));
        h.setStartingPrice(r.getBigDecimal("starting_price")); h.setAmenities(r.getString("amenities")); h.setCategory(r.getString("category"));
        h.setCheckInTime(r.getString("check_in_time")); h.setCheckOutTime(r.getString("check_out_time"));
        h.setLatitude(r.getDouble("latitude")); h.setLongitude(r.getDouble("longitude")); h.setFeatured(r.getBoolean("featured"));
        try { h.setImageUrl(r.getString("image_url")); } catch(SQLException ignored) {}
        return h;
    }
    public List<Hotel> findAll(String q) throws SQLException {
        List<Hotel> list=new ArrayList<>();
        String sql="SELECT h.*, (SELECT image_url FROM hotel_images i WHERE i.hotel_id=h.id ORDER BY image_order LIMIT 1) image_url FROM hotels h WHERE (?='' OR h.city LIKE ? OR h.name LIKE ?) ORDER BY h.featured DESC, h.guest_rating DESC";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            String s=q==null?"":q.trim(); p.setString(1,s); p.setString(2,"%"+s+"%"); p.setString(3,"%"+s+"%");
            try(ResultSet r=p.executeQuery()){while(r.next())list.add(map(r));}
        } return list;
    }
    public Hotel findById(int id) throws SQLException {
        String sql="SELECT h.*, (SELECT image_url FROM hotel_images i WHERE i.hotel_id=h.id ORDER BY image_order LIMIT 1) image_url FROM hotels h WHERE h.id=?";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){p.setInt(1,id);try(ResultSet r=p.executeQuery()){return r.next()?map(r):null;}}
    }
}
