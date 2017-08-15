package com.vamsikodali.egen.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Entity
public class Alert {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "vehiclevin", nullable = false)
    private Vehicle vehicle;
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private AlertType type;

    @ManyToOne
    @JoinColumn(name = "readingid", nullable = false)
    private Reading reading;

    public Alert() {
        this.id = UUID.randomUUID().toString();
    }

    public Alert(Vehicle vehicle, Reading reading, Priority priority, AlertType type) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.priority = priority;
        this.type = type;
        this.reading = reading;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public AlertType getType() {
        return type;
    }

    public void setType(AlertType type) {
        this.type = type;
    }

    public Reading getReading() {
        return reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
    }
}
