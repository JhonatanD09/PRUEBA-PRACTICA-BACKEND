package com.prueba.Client.application.handler;

import com.prueba.Client.application.dto.out.ClientResponse;
import com.prueba.Client.domain.model.Client;

public interface IClientHandler {

     ClientResponse getClient(char documentType, int documentNumber);
}
