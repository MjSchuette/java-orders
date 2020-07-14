package com.matthewschuette.javaorders.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long ordnum;

    private double ordamount;
    private double advanceamount;
    private String orderdescription;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties({"agent", "orders"})
    private Customers customer;

    @ManyToMany
    private List<Payments> payments = new ArrayList<>();

    public Orders() {
    }

    public Orders(long ordnum, double ordamount, double advanceamount, String orderdescription) {
        this.ordnum = ordnum;
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orderdescription = orderdescription;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }
}
