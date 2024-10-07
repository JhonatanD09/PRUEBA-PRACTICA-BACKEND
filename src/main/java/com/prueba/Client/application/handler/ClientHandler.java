package com.prueba.Client.application.handler;

import com.prueba.Client.application.dto.out.ClientResponse;
import com.prueba.Client.application.mapper.IClientMapper;
import com.prueba.Client.application.utils.Validators;
import com.prueba.Client.domain.api.IClientServicePort;
import com.prueba.Client.domain.model.Client;
import com.prueba.Client.infraestructure.exceptions.InvalidDocumentTypeException;
import com.prueba.Client.infraestructure.rest.ClientController;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientHandler implements IClientHandler {

    private final IClientServicePort iClientServicePort;
    private  final IClientMapper iClientMapper;
    private static  final Logger LOGGER = LoggerFactory.getLogger(ClientHandler.class);

    @Override
    public ClientResponse getClient(char documentType, int documentNumber) {
        if(Validators.valideTypeDocument(documentType)){
            LOGGER.info("Tipo de documento ok, se envia a consultar datos del cliente desde : " + getClass());
            return iClientMapper.toClientResponse(iClientServicePort.getClient(documentType,documentNumber));
        }else {
            LOGGER.error("Tipo de documento no coincide con C o P");
            throw  new InvalidDocumentTypeException();
        }
    }
}
