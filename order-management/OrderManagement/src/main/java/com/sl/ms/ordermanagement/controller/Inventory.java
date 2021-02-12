package com.sl.ms.ordermanagement.controller;


import javax.persistence.*;

@Entity
@Table(name="SL_ORDERS")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String totalAmount;

    public Inventory() {
        super();
    }

    public Inventory(Long id, String name, String totalAmount) {
        super();
        this.id = id;
        this.name = name;
        this.totalAmount = totalAmount;

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

}