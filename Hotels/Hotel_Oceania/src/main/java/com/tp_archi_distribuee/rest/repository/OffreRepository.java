package com.tp_archi_distribuee.rest.repository;

import com.tp_archi_distribuee.rest.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface OffreRepository extends JpaRepository<Offre, Integer> {
    ArrayList<Offre> findByAgenceId( int agenceId);
}
