package com.prueba.Client.infraestructure.rest;

import com.prueba.Client.application.dto.out.ClientResponse;
import com.prueba.Client.application.handler.IClientHandler;
import com.prueba.Client.infraestructure.exceptions.InvalidDocumentTypeException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final IClientHandler iClientHandler;
    private static  final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Operation(summary = "get Client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "client found", content = @Content),
            @ApiResponse(responseCode = "404", description = "client not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
    })
    @GetMapping
    public ResponseEntity<ClientResponse> getClient(  @RequestParam String documentType,
                                                      @RequestParam int documentNumber){
        if(documentType.isEmpty()){
            LOGGER.error("Tipo de documento vacio");
            throw  new InvalidDocumentTypeException();
        }else {
            LOGGER.info("Ejecutando desde "+ getClass() + " con info : Tipo de documento:" +documentType +
                    "numero de documento: " + documentNumber);
            return ResponseEntity.ok(iClientHandler.getClient(documentType.charAt(0), documentNumber));
        }
    }

}
