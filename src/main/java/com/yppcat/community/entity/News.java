package com.yppcat.community.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class News {
    @Id
    @GeneratedValue
    private Integer id;
    private String year;
    private String month;
    private String day;
    private String newStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


    public String getNewStr() {
        return newStr;
    }

    public void setNewStr(String newStr) {
        this.newStr = newStr;
    }
}
