package com.tp_archi_distribuee.rest.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    private String nom;
    @OneToMany
    private List<Chambre> chambres = new ArrayList<>();
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    @Getter
    @Setter
    private int nbLits;

    public Hotel (String nom, Adresse adresse, Categorie categorie, int nbLits){
        this.nom= nom;
        this.adresse = adresse;
        this.categorie= categorie;
        this.nbLits=nbLits;
    }
    public ArrayList<Chambre> getChambre(){
        return (ArrayList<Chambre>) Collections.unmodifiableCollection(chambres);
    }


    public void ajouterChambre( Chambre chambre){
        chambres.add( chambre);
        System.out.println("Chambre ajoutee");
    }
    @Override
    public String toString() {
        return "Hotel:" +
                "\nNom='" + nom + '\'' +
                "\nCategorie=" + categorie +
                "\nAdresse=" + adresse +
                "\nNombre de chhambres=" + chambres;
    }

}
