package com.prueba.Client;

import com.prueba.Client.application.dto.out.ClientResponse;
import com.prueba.Client.application.handler.ClientHandler;
import com.prueba.Client.application.mapper.IClientMapper;
import com.prueba.Client.domain.model.Client;
import com.prueba.Client.domain.useCase.ClientUseCase;
import com.prueba.Client.infraestructure.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ClientHandlerTest {

    @Mock
    private ClientUseCase clientUseCase;

    @Mock
    private IClientMapper iClientMapper;

    @InjectMocks
    private ClientHandler clienteService;

    private final char documentType = 'C';
    private final int documentNumber = 23445322;

    @BeforeEach
    void setup() {

        Client client = new Client("Jhonatan", "Daniel", "Marin", "Gomez",
                "3203961541", "Calle 5 sur #12-89", "Barbosa", 'C', 23445322);

        ClientResponse clientResponse = new ClientResponse("Jhonatan", "Daniel", "Marin", "Gomez",
                "3203961541", "Calle 5 sur #12-89", "Barbosa");


       Mockito.when(clientUseCase.getClient(documentType, documentNumber)).thenReturn(client);
       Mockito.when(iClientMapper.toClientResponse(client)).thenReturn(clientResponse);
    }

    @Test
    void getClient_exitoso() {
        ClientResponse client = clienteService.getClient(documentType, documentNumber);

        assertNotNull(client);
        assertEquals("Jhonatan", client.getFirstName());
        assertEquals("Marin", client.getFirstLastName());
    }

    @Test
    void clientNotFound() {

        Mockito.when(clientUseCase.getClient(documentType, 12345678)).thenThrow(new UserNotFoundException());

        assertThrows(UserNotFoundException.class, () -> {
            clienteService.getClient(documentType, 12345678);
        });
    }
}
