package com.deliverytech.delivery_api.dto;

import org.hibernate.annotations.processing.Pattern;

public class ClienteDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @Pattern(ragexp = "\\d{10,11}")
    private String telefone;
}
//