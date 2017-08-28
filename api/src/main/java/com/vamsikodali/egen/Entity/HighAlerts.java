package com.vamsikodali.egen.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HighAlerts {
    private long count;
    @Id
    private String vin;

    public HighAlerts(long count, String vin) {
        this.count = count;
        this.vin = vin;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
