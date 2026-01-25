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
@Entity
public class Agence {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
