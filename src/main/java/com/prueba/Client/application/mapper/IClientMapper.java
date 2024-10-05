package com.prueba.Client.application.mapper;

import com.prueba.Client.application.dto.in.ClientRequest;
import com.prueba.Client.application.dto.out.ClientResponse;
import com.prueba.Client.domain.model.Client;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IClientMapper {

    Client toClient(ClientRequest clientRequest);

    ClientResponse toClientResponse(Client client);
}
