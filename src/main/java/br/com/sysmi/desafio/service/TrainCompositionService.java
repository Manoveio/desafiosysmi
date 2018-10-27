package br.com.sysmi.desafio.service;

import br.com.sysmi.desafio.model.Vagao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

@Service
@Getter
@Setter
@AllArgsConstructor
public class TrainCompositionService {

    public static Deque<Vagao> train = new LinkedList<Vagao>();

    public void adicionaVagaoEsquerda(Vagao vagao) {
        train.addFirst(vagao);
    }

    public void adicionaVagaoDireita(Vagao vagao) {
        train.addLast(vagao);
    }

    public void removeVagaoEsquerda() {
        train.removeFirst();
    }

    public void removeVagaoDireita() {
        train.removeLast();
    }

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
