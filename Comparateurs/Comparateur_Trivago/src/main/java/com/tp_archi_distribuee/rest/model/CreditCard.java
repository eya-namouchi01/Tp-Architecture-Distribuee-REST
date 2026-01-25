package com.tp_archi_distribuee.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
    @Getter
    private Long id;
    @Getter
    @Setter
    private String numCarte;
    @Getter
    @Setter
    private String dateExpiration;
    @Getter
    @Setter
    private String cvv;

}
