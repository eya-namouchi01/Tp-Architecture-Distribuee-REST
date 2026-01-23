package com.tp_archi_distribuee.rest.repository;

import com.tp_archi_distribuee.rest.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
