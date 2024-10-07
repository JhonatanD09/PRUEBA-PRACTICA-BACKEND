package com.prueba.Client.domain.useCase;

import com.prueba.Client.domain.api.IClientServicePort;
import com.prueba.Client.domain.model.Client;
import com.prueba.Client.domain.spi.IClientPersistencePort;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class ClientUseCase implements IClientServicePort {

    private final IClientPersistencePort iClientPersistencePort;
    private static  final Logger LOGGER = LoggerFactory.getLogger(ClientUseCase.class);

    @Override
    public Client getClient(char documentType, int documentNumber) {
        LOGGER.info("Llega a la capa de dominio y consulta en la capa de persistencia");
        return iClientPersistencePort.getClient(documentType,documentNumber);
    }
}
