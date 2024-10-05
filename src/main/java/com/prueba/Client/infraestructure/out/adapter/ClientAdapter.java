package com.prueba.Client.infraestructure.out.adapter;

import com.prueba.Client.domain.model.Client;
import com.prueba.Client.domain.spi.IClientPersistencePort;
import com.prueba.Client.infraestructure.exceptions.InvalidDocumentTypeException;
import com.prueba.Client.infraestructure.exceptions.UserNotFoundException;
import com.prueba.Client.infraestructure.out.entity.EntityClient;
import com.prueba.Client.infraestructure.out.mapper.IClientInfMapper;
import com.prueba.Client.infraestructure.out.utils.UserDefault;
import com.prueba.Client.infraestructure.out.utils.Validators;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientAdapter implements IClientPersistencePort {

    private final IClientInfMapper iClientInfMapper;

    @Override
    public Client getClient(char documentType, int documentNumber) {
        EntityClient client = UserDefault.client();
        if(Validators.isClientDocumentType(client,documentType) &&
                Validators.isClientDocument(client,documentNumber)){
            return iClientInfMapper.toClient(client);
        }else{
            throw  new UserNotFoundException();
        }
    }
}
