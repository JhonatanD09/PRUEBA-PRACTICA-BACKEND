package com.prueba.Client.domain.api;

import com.prueba.Client.domain.model.Client;

public interface IClientServicePort {

    Client getClient(char documentType, int documentNumber);

}
