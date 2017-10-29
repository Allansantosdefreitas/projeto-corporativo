/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.ifpe.projetosofwarecasamento.repository;

import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Allan Santos
 */
public class Test {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("projetoSoftwareCasamentoPU");
    
    public static void main(String[] args) {

    Long idCasamento;
    
        try {
            
            idCasamento = inserirCasamento();

        } finally {
            EMF.close();
        }

    }

    public static Long inserirCasamento() {
        EntityManager em = null;
        EntityTransaction et = null;
        
        System.out.println("Vai setar o objeto");
        
        // Preenchendo atts
        Casamento casamento = new Casamento();
        casamento.setNome("Marriage of Dreams");

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(casamento);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }

            return casamento.getIdCasamento();
    }
}
