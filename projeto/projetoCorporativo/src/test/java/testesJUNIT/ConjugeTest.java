/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testesJUNIT;

import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import br.com.tads.ifpe.projetosofwarecasamento.model.Conjuge;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Allan Santos
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConjugeTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;
    private static Logger logger;
    private Conjuge conjuge = new Conjuge();

    public ConjugeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        logger = Logger.getGlobal();
        logger.setLevel(Level.INFO);

        emf = Persistence.createEntityManagerFactory("projetoSoftwareCasamentoPU"); // nome da PU
        //DbUnitUtil.inserirDados();

        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

    }

    @After
    public void tearDown() {

        try {
            et.commit();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());

            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
            em = null;
            et = null;
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//    @Test
//    public void a_inserirConjugeValidoEM() {
//
//        conjuge = preencherConjuge();
//        em.persist(conjuge);
//
//        assertNotNull(conjuge);
//    }

    /* Tem que ajeitar aqui..falta pegar o id da última entidade inserida para
        atualizar e não criar uma nova entidade */
//    @Test
//    public void b_atualizarConjugeValidoEM() {
//
//        //em.flush();
//        //conjuge = em.find(Conjuge.class, conjuge.getIdConjuge());
//        conjuge.setNome("NEW_Fulaninho");
//        em.merge(conjuge);
//
//        assertNotNull(conjuge);
//    }

//    @Ignore
//    @Test
//    public void c_consultarConjugeValidoEM() {
//        
//        conjuge = em.find(Conjuge.class, conjuge.getIdUsuario());
//        assertNotNull(conjuge);
//
//    }
//    
//    @Ignore
//    @Test
//    public void d_deletarConjugeValidoEM() {
//
//        em.remove(conjuge);
//
//        conjuge = em.find(Conjuge.class, conjuge.getIdUsuario());
//
//        assertNull(conjuge);
//    }
//
//    private static Conjuge preencherConjuge() {
//
//        // Preenchendo attrs
//        Conjuge conjuge = new Conjuge();
//        
//          // casamento
//        Casamento casamento = new Casamento();
//        casamento.setNome("Marriage of Dreams!");
//        
//        // Conjuge
//        conjuge.setCasamento(casamento);
//        conjuge.setNome("Fulaninho");
//        conjuge.setEmail("fulaninho@gmail.com");
//        conjuge.setLogin("fulaninhoLogin");
//        conjuge.setSenha("12345Fulaninho");
//        
//        return conjuge;
//    }

}
