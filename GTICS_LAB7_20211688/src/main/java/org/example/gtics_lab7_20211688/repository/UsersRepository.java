package org.example.gtics_lab7_20211688.repository;

import org.example.gtics_lab7_20211688.entity.Reservations;
import org.example.gtics_lab7_20211688.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
}
