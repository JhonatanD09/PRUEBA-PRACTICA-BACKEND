package com.prueba.Client.infraestructure.out.utils;

import com.prueba.Client.infraestructure.out.entity.EntityClient;

public class Validators {

    public static boolean isClientDocument(EntityClient client, int document){
        return client.getDocumentNumber() == document;
    }

    public static boolean isClientDocumentType(EntityClient client, char documentType){
        return Character.toUpperCase(client.getDocumentType()) == Character.toUpperCase(documentType);
    }
}
