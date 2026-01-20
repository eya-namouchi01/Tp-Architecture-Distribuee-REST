package com.tp_archi_distribuee.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    @Getter
    @Setter
    private String pays ;
    @Getter
    @Setter
    private String ville ;
    @Getter
    @Setter
    private String cite;
    @Getter
    @Setter
    private String rue;
    @Getter
    @Setter
    private String gpsPosition;

}
