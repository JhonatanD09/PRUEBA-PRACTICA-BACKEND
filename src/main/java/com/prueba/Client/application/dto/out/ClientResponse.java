package com.prueba.Client.application.dto.out;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ClientResponse {
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String phoneNumber;
    private String address;
    private String city;

}
