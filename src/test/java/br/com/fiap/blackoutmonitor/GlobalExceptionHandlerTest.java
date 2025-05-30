package br.com.fiap.blackoutmonitor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc //(addFilters = false) // desabilita filtros de segurança para fins de teste
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornarErro400ComMensagemDeCepInvalido() throws Exception {
        mockMvc.perform(get("/test/cep-invalido")
        		.with(httpBasic("usuario", "1234")))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("CEP inválido ou não encontrado"))
                .andExpect(jsonPath("$.path").value("/test/cep-invalido"))
                .andExpect(jsonPath("$.timestamp").exists());
    }
}
