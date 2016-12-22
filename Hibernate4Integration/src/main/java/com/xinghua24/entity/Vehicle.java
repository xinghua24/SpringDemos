package com.xinghua24.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicleid")
    private long vehicleId;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @ManyToOne(fetch = FetchType.LAZY , cascade=CascadeType.ALL)
    @JoinColumn(name = "userid", nullable = false)
    private AutoUser user;

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public AutoUser getUser() {
        return user;
    }

    public void setUser(AutoUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Vehicle [vehicleId=" + vehicleId + ", make=" + make + ", model=" + model +", userid=" + user.getUserId() +  "]";
    }

}
