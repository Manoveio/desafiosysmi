package br.com.sysmi.desafio;

import br.com.sysmi.desafio.model.Vagao;
import br.com.sysmi.desafio.service.TrainCompositionService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.UUID;


public class TrainCompositionUnitTests extends DesafiosysmiApplicationTests {

    @Autowired
    TrainCompositionService trainComposition;

    Vagao vagaoEsquerdo;
    Vagao vagaoDireito;

    @Before
    @Override
    public void contextLoads() {
        vagaoEsquerdo = new Vagao(UUID.randomUUID().getLeastSignificantBits(), new Timestamp(new Date().getTime()).toString(), "E");
        vagaoDireito = new Vagao(UUID.randomUUID().getLeastSignificantBits(), new Timestamp(new Date().getTime()).toString(), "D");
    }

    @Test
    public void adicionaVagaoDireita() {
        trainComposition.adicionaVagaoDireita(vagaoDireito);
        assert trainComposition.train.contains(vagaoDireito);
    }

    @Test
    public void adicionaVagaoEsquerda() {
       trainComposition.adicionaVagaoEsquerda(vagaoEsquerdo);
       assert trainComposition.train.contains(vagaoEsquerdo);
    }

    @Test
    public void removeDireita() {
        trainComposition.train = new LinkedList<Vagao>();
        trainComposition.adicionaVagaoDireita(vagaoDireito);
        trainComposition.removeVagaoDireita();
        assert !trainComposition.train.contains(vagaoDireito);
        assert 0 == trainComposition.train.size();
    }

    @Test
    public void removeEsquerda() {
        trainComposition.train = new LinkedList<Vagao>();
        trainComposition.adicionaVagaoEsquerda(vagaoEsquerdo);
        trainComposition.removeVagaoEsquerda();
        assert !trainComposition.train.contains(vagaoEsquerdo);
        assert 0 == trainComposition.train.size();
    }


}
