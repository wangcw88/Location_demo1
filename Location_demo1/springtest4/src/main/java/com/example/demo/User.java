package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String lng;
    private String lat;
    private String gps;
    private String wifi;
    public User(){
        super();
    }

    public User(Long id, String username, String password, String lng, String lat, String gps, String wifi) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.lng = lng;
        this.lat = lat;
        this.gps = gps;
        this.wifi = wifi;
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLng() {
        return lng;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getGps() { return gps; }

    public void setWifi(String wifi) { this.wifi = wifi;}

    public String getWifi() { return wifi; }
}
