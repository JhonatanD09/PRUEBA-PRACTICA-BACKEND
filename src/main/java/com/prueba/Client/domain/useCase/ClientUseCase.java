package com.prueba.Client.domain.useCase;

import com.prueba.Client.domain.api.IClientServicePort;
import com.prueba.Client.domain.model.Client;
import com.prueba.Client.domain.spi.IClientPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientUseCase implements IClientServicePort {

    private final IClientPersistencePort iClientPersistencePort;

    @Override
    public Client getClient(char documentType, int documentNumber) {
        return iClientPersistencePort.getClient(documentType,documentNumber);
    }
}
