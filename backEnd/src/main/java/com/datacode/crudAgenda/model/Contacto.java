package com.datacode.crudAgenda.model;

import lombok.Data;

@Data
public class Contacto {
    int id;
    String nombres;
    String apellidos;
    String celular;
    String email;
    String direccion;
    int estado;
}
