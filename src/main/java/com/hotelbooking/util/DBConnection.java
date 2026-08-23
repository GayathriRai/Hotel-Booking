package com.hotelbooking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    private static final String URL =
        "jdbc:mysql://hotel-db:3306/hotel_booking_db" +
        "?useSSL=false" +
        "&serverTimezone=Asia/Kolkata" +
        "&allowPublicKeyRetrieval=true";

    private static final String USER = "hotelapp";
    private static final String PASSWORD = "HotelApp@2026";

    private DBConnection() {}

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found in application classpath", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
