package com.example.routeoramaserver.models;

import java.io.Serializable;
import java.util.Objects;

public class Location implements Serializable {
    private double x, Y;
    private String Country;
    private String City;

    public Location(double x, double y, String country, String city) {
        this.x = x;
        Y = y;
        Country = country;
        City = city;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.x, x) == 0 && Double.compare(location.Y, Y) == 0 && Country.equals(location.Country) && City.equals(location.City);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, Y, Country, City);
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", Y=" + Y +
                ", Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
