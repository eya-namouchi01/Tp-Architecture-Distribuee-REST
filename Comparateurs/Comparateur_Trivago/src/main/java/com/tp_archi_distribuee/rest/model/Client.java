package com.tp_archi_distribuee.rest.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor

public class Client {
    @Getter
    private int id;
    @Getter
    private String email;
    @Getter
    @Setter
    private String nom;
    @Getter
    @Setter
    private String prenom;
    @Getter
    @Setter
    private String telephone;
    @Getter
    @Setter
    private CreditCard creditCard;
}
