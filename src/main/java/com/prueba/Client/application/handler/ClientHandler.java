package com.prueba.Client.application.handler;

import com.prueba.Client.application.dto.out.ClientResponse;
import com.prueba.Client.application.mapper.IClientMapper;
import com.prueba.Client.application.utils.Validators;
import com.prueba.Client.domain.api.IClientServicePort;
import com.prueba.Client.domain.model.Client;
import com.prueba.Client.infraestructure.exceptions.InvalidDocumentTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientHandler implements IClientHandler {

    private final IClientServicePort iClientServicePort;
    private  final IClientMapper iClientMapper;

    @Override
    public ClientResponse getClient(char documentType, int documentNumber) {
        if(Validators.valideTypeDocument(documentType)){
            return iClientMapper.toClientResponse(iClientServicePort.getClient(documentType,documentNumber));
        }else {
            throw  new InvalidDocumentTypeException();
        }
    }
}
