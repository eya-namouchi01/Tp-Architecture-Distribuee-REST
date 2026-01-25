package com.tp_archi_distribuee.rest.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor


public class Chambre {
    @Getter
    private int id;
    @Getter
    @Setter
    private int nbLits;
    @Getter
    @Setter
    private double prix;
    @Getter
    @Setter
    private byte[]  img;

}
