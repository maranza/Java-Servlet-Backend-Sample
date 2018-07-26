package org.coresystems.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.coresystems.model.Employee;

/**
 *
 * @author master
 */
public class EmployeeService {
    
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employeesdb");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    private static EntityTransaction transaction = null;
    
    public static boolean addRecord(Employee employee)
    {
        return (performTransaction(employee));
    }
    
    public static List<Employee> getRecords()
    {   
        transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createNativeQuery("SELECT * FROM employees");
        transaction.commit();
        transaction = null;
        return query.getResultList();
    }
    
    public static boolean deleteRecord(long id)
    {   
        transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createNativeQuery("DELETE FROM employees WHERE id = :id");
        query.setParameter("id", id).executeUpdate();
        transaction.commit();
        transaction = null;
        return true;
    }
    
    
    private static boolean performTransaction(Employee object) {
       
        transaction = null;
        
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(object);
            transaction.commit();
            
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Error Message:" + e);
            return false;
        }
        transaction = null;
        return true;
    }
    
}
