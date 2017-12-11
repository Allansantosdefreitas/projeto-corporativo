/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testesJUNIT;

import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import br.com.tads.ifpe.projetosofwarecasamento.model.Despesa;
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
public class DespesaTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;
    private static Logger logger;
    private Despesa despesa = new Despesa();

    public DespesaTest() {
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
//    public void a_inserirDespesaValidoEM() {
//
//        despesa = preencherDespesa();
//        em.persist(despesa);
//
//        assertNotNull(despesa);
//    }

    /* Tem que ajeitar aqui..falta pegar o id da última entidade inserida para
        atualizar e não criar uma nova entidade */
//    @Test
//    public void b_atualizarDespesaValidoEM() {
//
//        //em.flush();
//        //despesa = em.find(Despesa.class, despesa.getIdDespesa());
//        despesa.setDespesaAtual(0.0000);
//        em.merge(despesa);
//
//        assertNotNull(despesa);
//    }

//    @Ignore
//    @Test
//    public void c_consultarDespesaValidoEM() {
//        
//        despesa = em.find(Despesa.class, despesa.getIdDespesa());
//        assertNotNull(despesa);
//
//    }
//    
//    @Ignore
//    @Test
//    public void d_deletarDespesaValidoEM() {
//
//        em.remove(despesa);
//
//        despesa = em.find(Despesa.class, despesa.getIdDespesa());
//
//        assertNull(despesa);
//    }
//
//    private static Despesa preencherDespesa() {
//
//        // Preenchendo attrs
//        Despesa despesa = new Despesa();
//        
//          // casamento
//        Casamento casamento = new Casamento();
//        casamento.setNome("Marriage of Dreams!");
//        
//        
//        // Despesa
//        despesa.setCasamento(casamento);
//        despesa.setDespesaPrevista(20.000);
//        despesa.setDespesaAtual(10.000);
//        despesa.setValorRestante(10.000);
//        
//        return despesa;
//    }

}
