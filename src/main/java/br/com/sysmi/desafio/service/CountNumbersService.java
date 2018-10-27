package br.com.sysmi.desafio.service;


import br.com.sysmi.desafio.model.Resultado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Iterator;
@Service
@Getter
@Setter
@AllArgsConstructor
public class CountNumbersService {


    public void countNumbers(Resultado resultado) {

        Integer r = 0;
        Collections.sort(resultado.getIntegerList());
        Iterator iterator = resultado.getIntegerList().iterator();
        while((Integer)iterator.next() < resultado.getParam()) {
            r++;
        }
        resultado.setResult(r);
    }


}
