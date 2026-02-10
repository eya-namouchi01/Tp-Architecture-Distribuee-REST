package com.tp_archi_distribuee.rest.repository;

import com.tp_archi_distribuee.rest.model.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {
}
