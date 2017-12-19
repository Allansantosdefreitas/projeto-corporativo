/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testesJUNIT;

import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import br.com.tads.ifpe.projetosofwarecasamento.repository.CasamentoRepository;
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
import org.junit.runners.MethodSorters;

/**
 *
 * @author Allan Santos
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CasamentoTest {


    CasamentoRepository casamentoRepository = new CasamentoRepository();

    public CasamentoTest() {
    }

//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//        emf.close();
//    }
//
//    @Before
//    public void setUp() {
//        logger = Logger.getGlobal();
//        logger.setLevel(Level.INFO);
//
//        emf = Persistence.createEntityManagerFactory("projetoSoftwareCasamentoPU"); // nome da PU
//        //DbUnitUtil.inserirDados();
//
//        em = emf.createEntityManager();
//        et = em.getTransaction();
//        et.begin();
//
//    }
//
//    @After
//    public void tearDown() {
//
//        try {
//            et.commit();
//        } catch (Exception ex) {
//            logger.log(Level.SEVERE, ex.getMessage());
//
//            if (et.isActive()) {
//                et.rollback();
//            }
//        } finally {
//            em.close();
//            em = null;
//            et = null;
//        }
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void a_inserirCasamentoValidoEM() {

        Casamento casamento = preencherCasamento();
      
        assertNotNull(casamento);
    }

    /* Tem que ajeitar aqui..falta pegar o id da última entidade inserida para
        atualizar e não criar uma nova entidade */
//    @Test
//    public void b_atualizarCasamentoValidoEM() {
//
//        //em.flush();
//        //casamento = em.find(Casamento.class, casamento.getIdCasamento());
//        casamento.setNome("Marriage of OUR EXPECTED Dreams!!!!");
//        em.merge(casamento);
//
//        assertNotNull(casamento);
//    }

//
//    @Test
//    public void c_consultarCasamentoValidoEM() {
//        
//        casamento = em.find(Casamento.class, casamento.getIdCasamento());
//        assertNotNull(casamento);
//
//    }
    
//    @Test
//    public void d_deletarCasamentoValidoEM() {
//
//        em.remove(casamento);
//
//        casamento = em.find(Casamento.class, casamento.getIdCasamento());
//
//        assertNull(casamento);
//    }

    private static Casamento preencherCasamento() {

        // Preenchendo attrs
        Casamento casamento = new Casamento();
        CasamentoRepository casamentoRepository = new CasamentoRepository();
        
        casamento.setNome("Marriage of OUR Dreams");
        //casamento.setCodigo("$sskljdfj893u43kldfss$");

        casamentoRepository.inserir(casamento);
          
//        Conjuge conjuge = new Conjuge();
     

        return casamento;
    }

}
