package com.hotelbooking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/hotel_booking_db?useSSL=false&serverTimezone=Asia/Kolkata&allowPublicKeyRetrieval=true";

    private static final String USER = "hotelapp";
    private static final String PASSWORD = "YOUR_HOTELAPP_PASSWORD";

    private DBConnection() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
