package br.com.sysmi.desafio;

import br.com.sysmi.desafio.model.Resultado;
import br.com.sysmi.desafio.service.CountNumbersService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CountNumbersUnitTests extends DesafiosysmiApplicationTests{


    @Autowired
    CountNumbersService countNumbers;

    Resultado resultado;


    @Before
    @Override
    public void contextLoads() {
    Random rand = new Random();
        resultado = new Resultado();
        List<Integer> integerList = new ArrayList<Integer>();
        for(int i=0; i<9; i++) {
            integerList.add(rand.nextInt(20));
        }

        resultado.setParam(10);
        resultado.setIntegerList(integerList);
    }

    @Test
    public void countNumbers() {

        Integer a = 0;
        Integer b = 0;
        Boolean isAnOrderedList = true;
        countNumbers.countNumbers(resultado);

        Iterator iterator = resultado.getIntegerList().iterator();
        a = (Integer) iterator.next();

        while(iterator.hasNext()) {
           b = (Integer) iterator.next();
           isAnOrderedList = a <= b;
           if(!isAnOrderedList) break;
           a = b;
        }

        assert isAnOrderedList;
        assert resultado.getResult() != null;
    }
}
