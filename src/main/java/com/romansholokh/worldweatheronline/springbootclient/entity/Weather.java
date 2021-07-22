package com.romansholokh.worldweatheronline.springbootclient.entity;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@ToString
public class Weather {

    private int id;
    private String city;
    private String date;
    private String maxTemp;
    private String avgTemp;
    private String minTemp;
    private int numberOfInquiries;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    @Basic
    @Column(name = "max_temp")
    public String getMaxTemp() {
        return maxTemp;
    }

    @Basic
    @Column(name = "avg_temp")
    public String getAvgTemp() {
        return avgTemp;
    }

    @Basic
    @Column(name = "min_temp")
    public String getMinTemp() {
        return minTemp;
    }

    @Basic
    @Column(name = "number_of_inquiries")
    public int getNumberOfInquiries() {
        return numberOfInquiries;
    }
}
