package com.tp_archi_distribuee.rest.repository;

import com.tp_archi_distribuee.rest.model.Agence;
import com.tp_archi_distribuee.rest.model.Hotel;
import com.tp_archi_distribuee.rest.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Integer> {
    ArrayList<Offre> findByHotelId(int id);
    ArrayList<Offre> findByHotel(Hotel hotel);
    ArrayList<Offre> findByAgenceId( int agenceId);
}
