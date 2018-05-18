package tk.xdevcloud.medicalcore.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;

import tk.xdevcloud.medicalcore.models.Patient;

import java.util.List;

public class PatientService {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("medicaldb");
    private static EntityManager entityManager = emFactory.createEntityManager();


    public static boolean add(Patient patient) {

        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(patient);

            transaction.commit();
        } catch (Exception e) {

            transaction.rollback();
            return false;
        }


        return true;


    }

    public static List<Patient> getPatients() {


        Query query = entityManager.createQuery("SELECT p FROM patients p");
        return query.getResultList();


    }


    public static boolean delete(String idNumber) {


        Query query = entityManager.createNativeQuery("DELETE FROM patients WHERE id_number = :id");
        query.setParameter("id", idNumber).executeUpdate();
        return false;
    }

}
