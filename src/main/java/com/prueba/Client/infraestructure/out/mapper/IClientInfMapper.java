package com.prueba.Client.infraestructure.out.mapper;

import com.prueba.Client.domain.model.Client;
import com.prueba.Client.infraestructure.out.entity.EntityClient;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IClientInfMapper {

    @Mapping(target = "documentType", ignore = true)
    @Mapping(target = "documentNumber", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = {"documentType","documentNumber"})
    Client toClient(EntityClient client);

}
