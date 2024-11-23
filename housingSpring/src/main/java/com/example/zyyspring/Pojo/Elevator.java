package com.example.zyyspring.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "elevator")
public class Elevator {
    @Id
    @Column(name = "elevator")
    private String elevator;
    @Column(name = "count")
    private Long count;

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
