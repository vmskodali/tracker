package com.vamsikodali.egen.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "SELECT veh FROM Vehicle veh ORDER BY veh.make DESC")
})
public class Vehicle {
    @Id
    private String vin;
    private String make;
    private String model;
    private int year;
    private int redLineRpm;
    private int maxFuelVolume;
    private String lastServiceDate;


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedLineRpm() {
        return redLineRpm;
    }

    public void setRedLineRpm(int redLineRpm) {
        this.redLineRpm = redLineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}
