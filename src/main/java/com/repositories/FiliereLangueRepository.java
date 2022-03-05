package com.repositories;

import com.entities.Cours;
import com.entities.FiliereLangue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereLangueRepository extends JpaRepository<FiliereLangue, Long> {
}
