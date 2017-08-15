package com.vamsikodali.egen.repository;

import com.vamsikodali.egen.Entity.Alert;
import com.vamsikodali.egen.Entity.Reading;

public interface ReadingRepository {
    void createReading(Reading reading);
    void createAlert(Alert alert);
}
