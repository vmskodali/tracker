package com.vamsikodali.egen.repository;

import com.vamsikodali.egen.Entity.Alert;
import com.vamsikodali.egen.Entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Repository
public class AlertRepositoryImpl implements AlertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createAlert(Alert alert) {
        entityManager.persist(alert);
    }

    public List<Alert> findAllAlerts() {
        TypedQuery<Alert> query = entityManager.createQuery("SELECT alr FROM Alert alr join alr.vehicle v join alr.reading r where alr.priority = 'HIGH' and r.timestamp>:timestamp ORDER BY v.vin",
                Alert.class);
        //TypedQuery<Alert> query = entityManager.createQuery("SELECT v.vin, count(*) as count  FROM Alert alr join alr.vehicle v join alr.reading r where alr.priority = 'HIGH' and r.timestamp>:timestamp group by BY v.vin",Alert.class);

        query.setParameter("timestamp", new Date(System.currentTimeMillis() - 7200 * 1000));
        return query.getResultList();
    }
    public List<HighAlerts> findHighAlertCount() {
        TypedQuery<HighAlerts> query = entityManager.createQuery("SELECT NEW com.vamsikodali.egen.Entity.HighAlerts(COUNT(v.vin),  v.vin) FROM Alert alr join alr.vehicle v join alr.reading r where alr.priority = 'HIGH' and r.timestamp>:timestamp GROUP BY v.vin ORDER BY v.vin",
                HighAlerts.class);
        //TypedQuery<Alert> query = entityManager.createQuery("SELECT v.vin, count(*) as count  FROM Alert alr join alr.vehicle v join alr.reading r where alr.priority = 'HIGH' and r.timestamp>:timestamp group by BY v.vin",Alert.class);

        query.setParameter("timestamp", new Date(System.currentTimeMillis() - 7200 * 1000));
        return query.getResultList();
    }

    public List<Alert> findAlertsByVehicle(String vin) {
        TypedQuery<Alert> query = entityManager.createQuery("SELECT alr FROM Alert alr join alr.vehicle v join alr.reading r where v.vin=:vin",
                Alert.class);
        query.setParameter("vin", vin);
        return query.getResultList();
    }
}
