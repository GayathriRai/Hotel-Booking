package com.hotelbooking.model;
public class HotelImage {
    private int id, hotelId, imageOrder; private String imageUrl;
    public int getId(){return id;} public void setId(int v){id=v;}
    public int getHotelId(){return hotelId;} public void setHotelId(int v){hotelId=v;}
    public int getImageOrder(){return imageOrder;} public void setImageOrder(int v){imageOrder=v;}
    public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
}
