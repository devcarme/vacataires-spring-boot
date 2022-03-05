package com.repositories;

import com.entities.Cours;
import com.entities.SeanceFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceFormationRepository extends JpaRepository<SeanceFormation, Long> {
}
