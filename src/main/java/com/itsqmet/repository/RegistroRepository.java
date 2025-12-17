package com.itsqmet.repository;

import com.itsqmet.entity.RegistroEmocional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<RegistroEmocional, Long> {
}
