package com.alessor.app.ws.shared.dtos;

import java.io.Serializable;

public class PropertyDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long Id;
    private String PropertyId;
    private String Street;
    private String City;
    private String Zipcode;
    private String County;
    private String State;
    private Double Bedrooms;
    private Double Bathrooms;
    private Float Price;
    private Boolean IsRental;
    private double Latitude;
    private double Longitude;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getPropertyId() {
        return PropertyId;
    }

    public void setPropertyId(String propertyId) {
        this.PropertyId = propertyId;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        this.Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        this.Zipcode = zipcode;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        this.County = county;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        this.State = state;
    }

    public Double getBedrooms() {
        return Bedrooms;
    }

    public void setBedrooms(Double bedrooms) {
        this.Bedrooms = bedrooms;
    }

    public Double getBathrooms() {
        return Bathrooms;
    }

    public void setBathrooms(Double bathrooms) {
        this.Bathrooms = bathrooms;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        this.Price = price;
    }

    public Boolean getIsRental() {
        return IsRental;
    }

    public void setIsRental(Boolean isRental) {
        this.IsRental = isRental;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        this.Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        this.Longitude = longitude;
    }
}
