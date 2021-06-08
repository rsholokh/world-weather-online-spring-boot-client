package com.romansholokh.worldweatheronline.springbootclient.entity;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Setter
public class Weather {

    private int id;
    private String city;
    private Date date;
    private String maxTemp;
    private String avgTemp;
    private String minTemp;
    private int numberOfInquiries;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    @Basic
    @Column(name = "max_temp", nullable = false)
    public String getMaxTemp() {
        return maxTemp;
    }

    @Basic
    @Column(name = "avg_temp", nullable = false)
    public String getAvgTemp() {
        return avgTemp;
    }

    @Basic
    @Column(name = "min_temp", nullable = false)
    public String getMinTemp() {
        return minTemp;
    }

    @Basic
    @Column(name = "number_of_inquiries", nullable = false)
    public int getNumberOfInquiries() {
        return numberOfInquiries;
    }
}
