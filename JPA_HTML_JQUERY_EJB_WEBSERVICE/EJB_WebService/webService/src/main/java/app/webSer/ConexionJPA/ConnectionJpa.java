/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.webSer.ConexionJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author angel
 */
public class ConnectionJpa {
    
    private static EntityManagerFactory emf = null;
    
    public static EntityManager createEntityManager() {
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("app_webService_war_1.0PU");
            }
        } catch (Exception e) {
            System.out.println("Error, "+e.getMessage());
        }
        return emf.createEntityManager();
    }
    
    public static void disconnection(EntityManager entityManager) {
        if (entityManager != null) {
            entityManager.close();
            emf.close();
        }
    }
    
}
