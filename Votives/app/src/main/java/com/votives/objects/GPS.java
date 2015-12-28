package com.votives.objects;

/**
 * Created by tinyiota on 12/27/15.
 */
public class GPS {
    double latitude;
    double longitude;

    public GPS(){

    }

    public GPS(double latitude, double longitude){
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
