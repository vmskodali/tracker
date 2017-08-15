package com.vamsikodali.egen.repository;

import com.vamsikodali.egen.Entity.Alert;
import com.vamsikodali.egen.Entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void createReading(Reading reading) {
        entityManager.persist(reading.getTires());
        entityManager.persist(reading);
    }

    public void createAlert(Alert alert) {
        entityManager.persist(alert);
    }
}
