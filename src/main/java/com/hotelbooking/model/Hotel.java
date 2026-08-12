package com.hotelbooking.model;

import java.math.BigDecimal;

public class Hotel {
    private int id;
    private String name, city, state, address, description, amenities, category, checkInTime, checkOutTime;
    private double starRating, guestRating, latitude, longitude;
    private int reviewCount;
    private BigDecimal startingPrice;
    private boolean featured;
    private String imageUrl;

    public Hotel() {}
    public Hotel(int id, String name, String city, String state, String address, String description,
                 double starRating, double guestRating, int reviewCount, BigDecimal startingPrice,
                 String amenities, String category, String checkInTime, String checkOutTime,
                 double latitude, double longitude, boolean featured, String imageUrl) {
        this.id=id; this.name=name; this.city=city; this.state=state; this.address=address;
        this.description=description; this.starRating=starRating; this.guestRating=guestRating;
        this.reviewCount=reviewCount; this.startingPrice=startingPrice; this.amenities=amenities;
        this.category=category; this.checkInTime=checkInTime; this.checkOutTime=checkOutTime;
        this.latitude=latitude; this.longitude=longitude; this.featured=featured; this.imageUrl=imageUrl;
    }
    public int getId(){return id;} public void setId(int v){id=v;}
    public String getName(){return name;} public void setName(String v){name=v;}
    public String getCity(){return city;} public void setCity(String v){city=v;}
    public String getState(){return state;} public void setState(String v){state=v;}
    public String getAddress(){return address;} public void setAddress(String v){address=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public double getStarRating(){return starRating;} public void setStarRating(double v){starRating=v;}
    public double getGuestRating(){return guestRating;} public void setGuestRating(double v){guestRating=v;}
    public int getReviewCount(){return reviewCount;} public void setReviewCount(int v){reviewCount=v;}
    public BigDecimal getStartingPrice(){return startingPrice;} public void setStartingPrice(BigDecimal v){startingPrice=v;}
    public String getAmenities(){return amenities;} public void setAmenities(String v){amenities=v;}
    public String getCategory(){return category;} public void setCategory(String v){category=v;}
    public String getCheckInTime(){return checkInTime;} public void setCheckInTime(String v){checkInTime=v;}
    public String getCheckOutTime(){return checkOutTime;} public void setCheckOutTime(String v){checkOutTime=v;}
    public double getLatitude(){return latitude;} public void setLatitude(double v){latitude=v;}
    public double getLongitude(){return longitude;} public void setLongitude(double v){longitude=v;}
    public boolean isFeatured(){return featured;} public void setFeatured(boolean v){featured=v;}
    public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
}
