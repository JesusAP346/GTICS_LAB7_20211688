package org.example.gtics_lab7_20211688.repository;

import org.example.gtics_lab7_20211688.entity.Roles;
import org.example.gtics_lab7_20211688.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository  extends JpaRepository<Roles,Integer> {
}
