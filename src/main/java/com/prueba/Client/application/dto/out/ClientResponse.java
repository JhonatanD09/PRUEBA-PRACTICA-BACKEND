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

    public ClientResponse(String firstName, String secondName, String firstLastName, String secondLastName, String phoneNumber, String address,
                        String city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city =city;
    }
}
