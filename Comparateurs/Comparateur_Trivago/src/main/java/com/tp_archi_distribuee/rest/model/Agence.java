package com.tp_archi_distribuee.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
public class Agence {
    @Getter
    private int id;
    @Getter
    @Setter
    private String nom;
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String motDePasse;



    public Agence(int agencyId, String nom, String login, String motDePasse) {
        this.id = agencyId;
        this.nom = nom;
        this.login = login;
        this.motDePasse = motDePasse;
    }
    public boolean authentifier(String login, String motDePasse) {
        return this.login.equals(login) && this.motDePasse.equals(motDePasse);
    }

}
