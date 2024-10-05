package com.prueba.Client.domain.spi;

import com.prueba.Client.domain.model.Client;

public interface IClientPersistencePort {

    Client getClient(char documentType, int documentNumber);

}
