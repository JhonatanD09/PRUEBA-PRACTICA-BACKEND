package com.prueba.Client.infraestructure.config;

import com.prueba.Client.domain.api.IClientServicePort;
import com.prueba.Client.domain.spi.IClientPersistencePort;
import com.prueba.Client.domain.useCase.ClientUseCase;
import com.prueba.Client.infraestructure.out.adapter.ClientAdapter;
import com.prueba.Client.infraestructure.out.mapper.IClientInfMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {


    private final IClientInfMapper iClientInfMapper;

    @Bean
    public  IClientPersistencePort iClientPersistencePort(){
        return  new ClientAdapter(iClientInfMapper);
    }

    @Bean
    public IClientServicePort iClientServicePort(){
        return  new ClientUseCase(iClientPersistencePort());
    }

}
