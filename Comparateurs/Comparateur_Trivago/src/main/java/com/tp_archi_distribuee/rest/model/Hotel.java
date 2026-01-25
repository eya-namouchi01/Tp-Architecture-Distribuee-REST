package com.tp_archi_distribuee.rest.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Getter
    private int id;
    @Getter
    @Setter
    private String nom;
    private List<Chambre> chambres = new ArrayList<>();
    @Getter
    @Setter
    private Adresse adresse;
    @Getter
    @Setter
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
