package com.prueba.Client.infraestructure.out.adapter;

import com.prueba.Client.domain.model.Client;
import com.prueba.Client.domain.spi.IClientPersistencePort;
import com.prueba.Client.domain.useCase.ClientUseCase;
import com.prueba.Client.infraestructure.exceptions.InvalidDocumentTypeException;
import com.prueba.Client.infraestructure.exceptions.UserNotFoundException;
import com.prueba.Client.infraestructure.out.entity.EntityClient;
import com.prueba.Client.infraestructure.out.mapper.IClientInfMapper;
import com.prueba.Client.infraestructure.out.utils.UserDefault;
import com.prueba.Client.infraestructure.out.utils.Validators;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class ClientAdapter implements IClientPersistencePort {

    private final IClientInfMapper iClientInfMapper;
    private static  final Logger LOGGER = LoggerFactory.getLogger(ClientAdapter.class);

    @Override
    public Client getClient(char documentType, int documentNumber) {
        EntityClient client = UserDefault.client();
        if(Validators.isClientDocumentType(client,documentType) &&
                Validators.isClientDocument(client,documentNumber)){
            LOGGER.info("Consulta del cliente desde la clase " + getClass());
            return iClientInfMapper.toClient(client);
        }else{
            LOGGER.error("El tipo o numero de documento no coinciden con los registros almacenados");
            throw  new UserNotFoundException();
        }
    }
}
