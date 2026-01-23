package com.tp_archi_distribuee.rest.repository;

import com.tp_archi_distribuee.rest.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
