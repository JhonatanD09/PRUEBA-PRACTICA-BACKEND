package com.prueba.Client.infraestructure.out.utils;

import com.prueba.Client.infraestructure.out.entity.EntityClient;

public class UserDefault {

    public static EntityClient client(){
        return new EntityClient("Jhonatan","Daniel","Marin","Gomez","3203961541","Calle 5 sur #12-89","Barbosa", 'C', 23445322);
    }
}
