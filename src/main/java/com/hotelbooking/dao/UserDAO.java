package com.hotelbooking.dao;
import com.hotelbooking.model.User; import com.hotelbooking.util.DBConnection; import java.sql.*;
public class UserDAO {
 public User findByEmail(String email)throws SQLException{String s="SELECT * FROM users WHERE email=?";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(s)){p.setString(1,email);try(ResultSet r=p.executeQuery()){if(!r.next())return null;User u=new User();u.setId(r.getInt("id"));u.setFullName(r.getString("full_name"));u.setEmail(r.getString("email"));u.setPhone(r.getString("phone"));u.setPasswordHash(r.getString("password_hash"));return u;}}
 }
 public int create(User u)throws SQLException{String s="INSERT INTO users(full_name,email,phone,password_hash) VALUES(?,?,?,?)";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(s,Statement.RETURN_GENERATED_KEYS)){p.setString(1,u.getFullName());p.setString(2,u.getEmail());p.setString(3,u.getPhone());p.setString(4,u.getPasswordHash());p.executeUpdate();try(ResultSet r=p.getGeneratedKeys()){return r.next()?r.getInt(1):0;}}
 }
}
