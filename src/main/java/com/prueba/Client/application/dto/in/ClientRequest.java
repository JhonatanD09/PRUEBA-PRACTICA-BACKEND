package com.prueba.Client.application.dto.in;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ClientRequest {

    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String phoneNumber;
    private String address;
    private String city;
    private char documentType;
    private int documentNumber;

}
