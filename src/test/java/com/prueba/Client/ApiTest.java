package com.prueba.Client;

import com.prueba.Client.application.dto.out.ClientResponse;
import com.prueba.Client.application.handler.IClientHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApiTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private IClientHandler iClientHandler;

	@Test
	public void testApi() throws Exception {

		ClientResponse clientResponse = new ClientResponse("Jhonatan", "Daniel", "Marin", "Gomez",
				"3203961541", "Calle 5 sur #12-89", "Barbosa");


		when(iClientHandler.getClient('C', 23445322)).thenReturn(clientResponse);


		mockMvc.perform(get("/api/client")
						.param("documentType", "C")
						.param("documentNumber", "23445322"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value("Jhonatan"))
				.andExpect(jsonPath("$.firstLastName").value("Marin"));
	}

	@Test
	public void testApiBadUrl() throws Exception {


		mockMvc.perform(get("/api/clients")
						.param("documentType", "C")
						.param("documentNumber", "23445322"))
				.andExpect(status().isNotFound());
	}

	@Test
	public void testApiBadRequest() throws Exception {

		mockMvc.perform(get("/api/client")
						.param("documentType", "")
						.param("documentNumber", "23445322"))
				.andExpect(status().isBadRequest());
	}
}
