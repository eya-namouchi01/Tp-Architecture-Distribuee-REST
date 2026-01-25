package com.tp_archi_distribuee.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
public class Adresse {
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
    private String rue;
    @Getter
    @Setter
    private String gpsPosition;

}
