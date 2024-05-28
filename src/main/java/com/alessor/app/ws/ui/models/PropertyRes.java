package com.alessor.app.ws.ui.models;

public class PropertyRes {
    private String PropertyId;
    private String Street;
    private String City;
    private String Zipcode;
    private Boolean IsRental;

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

    public Boolean getIsRental() {
        return IsRental;
    }

    public void setIsRental(Boolean isRental) {
        this.IsRental = isRental;
    }
}
