package com.tp_archi_distribuee.rest.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Chambre {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    private int nbLits;
    @Getter
    @Setter
    private double prix;
    @Getter
    @Setter
    @Lob
    private byte[]  img;

}
