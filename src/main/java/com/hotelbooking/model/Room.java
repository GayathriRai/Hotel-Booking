package com.hotelbooking.model;
import java.math.BigDecimal;
public class Room {
    private int id, hotelId, maxGuests, availableRooms;
    private String roomName, description, bedType;
    private BigDecimal pricePerNight;
    public int getId(){return id;} public void setId(int v){id=v;}
    public int getHotelId(){return hotelId;} public void setHotelId(int v){hotelId=v;}
    public int getMaxGuests(){return maxGuests;} public void setMaxGuests(int v){maxGuests=v;}
    public int getAvailableRooms(){return availableRooms;} public void setAvailableRooms(int v){availableRooms=v;}
    public String getRoomName(){return roomName;} public void setRoomName(String v){roomName=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public String getBedType(){return bedType;} public void setBedType(String v){bedType=v;}
    public BigDecimal getPricePerNight(){return pricePerNight;} public void setPricePerNight(BigDecimal v){pricePerNight=v;}
}
