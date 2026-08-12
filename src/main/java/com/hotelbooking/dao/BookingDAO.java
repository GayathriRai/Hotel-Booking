package com.hotelbooking.dao;

import com.hotelbooking.model.Booking;
import com.hotelbooking.util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public String create(Booking booking) throws SQLException {

        String sql = """
                INSERT INTO bookings
                (
                    booking_id,
                    user_id,
                    hotel_id,
                    room_id,
                    guest_name,
                    guest_email,
                    guest_phone,
                    check_in,
                    check_out,
                    adults,
                    children,
                    rooms,
                    subtotal,
                    tax,
                    service_fee,
                    total_amount,
                    status
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, booking.getBookingId());
            statement.setInt(2, booking.getUserId());
            statement.setInt(3, booking.getHotelId());
            statement.setInt(4, booking.getRoomId());

            statement.setString(5, booking.getGuestName());
            statement.setString(6, booking.getGuestEmail());
            statement.setString(7, booking.getGuestPhone());

            /*
             * Explicitly use java.sql.Date.
             *
             * This avoids the ambiguity between:
             * java.util.Date
             * java.sql.Date
             */
            statement.setDate(
                    8,
                    Date.valueOf(booking.getCheckIn())
            );

            statement.setDate(
                    9,
                    Date.valueOf(booking.getCheckOut())
            );

            statement.setInt(10, booking.getAdults());
            statement.setInt(11, booking.getChildren());
            statement.setInt(12, booking.getRooms());

            statement.setBigDecimal(
                    13,
                    booking.getSubtotal()
            );

            statement.setBigDecimal(
                    14,
                    booking.getTax()
            );

            statement.setBigDecimal(
                    15,
                    booking.getServiceFee()
            );

            statement.setBigDecimal(
                    16,
                    booking.getTotalAmount()
            );

            statement.setString(
                    17,
                    "CONFIRMED"
            );

            statement.executeUpdate();
        }

        return booking.getBookingId();
    }


    public List<Booking> findByUser(int userId)
            throws SQLException {

        List<Booking> bookings = new ArrayList<>();

        String sql = """
                SELECT
                    b.*,
                    h.name AS hotel_name,
                    r.room_name
                FROM bookings b
                JOIN hotels h
                    ON h.id = b.hotel_id
                JOIN rooms r
                    ON r.id = b.room_id
                WHERE b.user_id = ?
                ORDER BY b.created_at DESC
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, userId);

            try (
                    ResultSet resultSet =
                            statement.executeQuery()
            ) {

                while (resultSet.next()) {

                    Booking booking = new Booking();

                    booking.setBookingId(
                            resultSet.getString("booking_id")
                    );

                    booking.setHotelName(
                            resultSet.getString("hotel_name")
                    );

                    booking.setRoomName(
                            resultSet.getString("room_name")
                    );

                    Date checkIn =
                            resultSet.getDate("check_in");

                    Date checkOut =
                            resultSet.getDate("check_out");

                    if (checkIn != null) {
                        booking.setCheckIn(
                                checkIn.toLocalDate()
                        );
                    }

                    if (checkOut != null) {
                        booking.setCheckOut(
                                checkOut.toLocalDate()
                        );
                    }

                    booking.setAdults(
                            resultSet.getInt("adults")
                    );

                    booking.setChildren(
                            resultSet.getInt("children")
                    );

                    booking.setTotalAmount(
                            resultSet.getBigDecimal(
                                    "total_amount"
                            )
                    );

                    booking.setStatus(
                            resultSet.getString("status")
                    );

                    bookings.add(booking);
                }
            }
        }

        return bookings;
    }


    public void cancel(
            String bookingId,
            int userId
    ) throws SQLException {

        String sql = """
                UPDATE bookings
                SET status = 'CANCELLED'
                WHERE booking_id = ?
                  AND user_id = ?
                  AND status = 'CONFIRMED'
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, bookingId);
            statement.setInt(2, userId);

            statement.executeUpdate();
        }
    }
}