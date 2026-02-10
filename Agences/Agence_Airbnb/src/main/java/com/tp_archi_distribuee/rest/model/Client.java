package com.tp_archi_distribuee.rest.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Getter
    private int id;
    @Id
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
    @OneToOne
    @JoinColumn(name = "creditCard_id")
    private CreditCard creditCard;
}
