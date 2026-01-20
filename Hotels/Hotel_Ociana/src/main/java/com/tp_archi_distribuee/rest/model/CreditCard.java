package com.tp_archi_distribuee.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCard {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
