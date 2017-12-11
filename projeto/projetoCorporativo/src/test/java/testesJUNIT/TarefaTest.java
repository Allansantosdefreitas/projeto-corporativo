/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testesJUNIT;

import br.com.tads.ifpe.projetosofwarecasamento.model.Casamento;
import br.com.tads.ifpe.projetosofwarecasamento.model.Servico;
import br.com.tads.ifpe.projetosofwarecasamento.model.StatusTarefa;
import br.com.tads.ifpe.projetosofwarecasamento.model.Tarefa;
import java.util.Calendar;
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
public class TarefaTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;
    private static Logger logger;
    private Tarefa tarefa = new Tarefa();

    public TarefaTest() {
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
//    public void a_inserirTarefaValidoEM() {
//
//        tarefa = preencherTarefa();
//        em.persist(tarefa);
//
//        assertNotNull(tarefa);
//    }

    /* Tem que ajeitar aqui..falta pegar o id da última entidade inserida para
        atualizar e não criar uma nova entidade */
//    @Test
//    public void b_atualizarTarefaValidoEM() {
//
//        //em.flush();
//        //tarefa = em.find(Tarefa.class, tarefa.getIdTarefa());
//        tarefa.setTitulo("NEW_Contratar Buffet");
//        em.merge(tarefa);
//
//        assertNotNull(tarefa);
//    }

//    @Ignore
//    @Test
//    public void c_consultarTarefaValidoEM() {
//        
//        tarefa = em.find(Tarefa.class, tarefa.getIdTarefa());
//        assertNotNull(tarefa);
//
//    }
    
//    @Ignore
//    @Test
//    public void d_deletarTarefaValidoEM() {
//
//        em.remove(tarefa);
//
//        tarefa = em.find(Tarefa.class, tarefa.getIdTarefa());
//
//        assertNull(tarefa);
//    }

//    private static Tarefa preencherTarefa() {
//
//        // Preenchendo attrs
//        Tarefa tarefa = new Tarefa();
//        
//          // casamento
//        Casamento casamento = new Casamento();
//        casamento.setNome("Tarefa_Marriage of Dreams!");
//        
//        // Tarefa
//        tarefa.setCasamento(casamento);
//        tarefa.setDescricao("Toda a parte de contratação do buffet com doces, salgados etc.");
//        
//        Calendar calendario = Calendar.getInstance();
//        calendario.set(2017, 10, 29);
//        
//        tarefa.setData(calendario.getTime());
//        tarefa.setStatus(StatusTarefa.PENDENTE);
//        
//        Servico servico = new Servico();
//        tarefa.setServico(servico);
//        
//        return tarefa;
//    }

}
