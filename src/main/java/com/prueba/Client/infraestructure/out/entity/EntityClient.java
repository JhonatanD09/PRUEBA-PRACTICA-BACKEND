package com.prueba.Client.infraestructure.out.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EntityClient {

    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String phoneNumber;
    private String address;
    private String city;
    private char documentType;
    private int documentNumber;

    public EntityClient(String firstName, String secondName, String firstLastName, String secondLastName, String phoneNumber, String address,
                        String city, char documentType, int documentNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city =city;
        this.documentType =documentType;
        this.documentNumber = documentNumber;
    }
}
