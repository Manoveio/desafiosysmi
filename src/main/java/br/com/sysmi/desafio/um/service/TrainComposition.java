package br.com.sysmi.desafio.um.service;

import br.com.sysmi.desafio.um.model.Vagao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

@Service
@Getter
@Setter
@AllArgsConstructor
public class TrainComposition {

    public static Deque<Vagao> train = new LinkedList<Vagao>();

    public String result() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = train.iterator();
        int i = train.size();

        while (iterator.hasNext()) {
            stringBuilder.append("[\"");
            stringBuilder.append(iterator.next());
            stringBuilder.append("\"]");

            if(i > 1) {
                stringBuilder.append(" + ");
            }
            i--;
        }

        return stringBuilder.toString();
    }
}
