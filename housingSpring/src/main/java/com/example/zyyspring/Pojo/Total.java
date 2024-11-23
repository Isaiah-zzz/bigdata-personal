package com.example.zyyspring.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "total")
public class Total {
    @Id
    @Column(name = "summary")
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getToal_price() {
        return toal_price;
    }

    public void setToal_price(Long toal_price) {
        this.toal_price = toal_price;
    }

    @Column(name = "total_price")
    private Long toal_price;

}
