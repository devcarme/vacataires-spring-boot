package com.repositories;

import com.entities.Cours;
import com.entities.Creneau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreaneauRepository extends JpaRepository<Creneau, Long> {
}
