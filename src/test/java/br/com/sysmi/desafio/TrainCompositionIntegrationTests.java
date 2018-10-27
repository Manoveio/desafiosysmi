package br.com.sysmi.desafio;

import br.com.sysmi.desafio.controller.TrainController;
import br.com.sysmi.desafio.model.Vagao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrainCompositionIntegrationTests extends DesafiosysmiApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    TrainController trainController;

    Vagao vagaoEsquerdo;
    Vagao vagaoDireito;


    @Before
    @Override
    public void contextLoads() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/templates/");
        viewResolver.setSuffix(".html");
        this.mockMvc = MockMvcBuilders.standaloneSetup(trainController).build();
        vagaoEsquerdo = new Vagao(UUID.randomUUID().getLeastSignificantBits(), new Timestamp(new Date().getTime()).toString(), "E");
        vagaoDireito = new Vagao(UUID.randomUUID().getLeastSignificantBits(), new Timestamp(new Date().getTime()).toString(), "D");
        assertThat(trainController).isNotNull();
    }



    @Test
    public void compoeTremController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/compoetrem"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("vagao"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
