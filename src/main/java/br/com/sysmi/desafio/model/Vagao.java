package br.com.sysmi.desafio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vagao {

    Long id;
    Object conteudo;
    String engate;

    @Override
    public boolean equals(Object o) {
        return o == this;
    }

    @Override
    public String toString() {
        return "\"id\":\"" + id + "\", " +
                "\"conteudo\":\"" + conteudo +"\", " +
                "\"engate\":\"" + engate + "\"";
    }
}
