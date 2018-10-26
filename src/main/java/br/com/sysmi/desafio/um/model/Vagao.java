package br.com.sysmi.desafio.um.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vagao {

    String id;
    String conteudo;
    String engate;


    @Override
    public String toString() {
        return "\"id\":\"" + id + "\", " +
                "\"conteudo\":\"" + conteudo +"\", " +
                "\"engate\":\"" + engate +"\"";
    }
}
