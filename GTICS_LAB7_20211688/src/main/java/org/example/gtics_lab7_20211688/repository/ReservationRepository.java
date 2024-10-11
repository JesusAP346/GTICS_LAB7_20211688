package org.example.gtics_lab7_20211688.repository;

import org.example.gtics_lab7_20211688.entity.Reservations;
import org.example.gtics_lab7_20211688.entity.RoomSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations,Integer> {
}
