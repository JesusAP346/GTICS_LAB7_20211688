package org.example.gtics_lab7_20211688.repository;

import org.example.gtics_lab7_20211688.entity.Obras;
import org.example.gtics_lab7_20211688.entity.RoomSeats;
import org.example.gtics_lab7_20211688.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomSeatsRepository extends JpaRepository<RoomSeats,Integer> {
}
