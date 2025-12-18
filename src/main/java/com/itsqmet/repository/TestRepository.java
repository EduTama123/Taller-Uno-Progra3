package com.itsqmet.repository;

import com.itsqmet.entity.TestAnsiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestAnsiedad, Long> {
}
