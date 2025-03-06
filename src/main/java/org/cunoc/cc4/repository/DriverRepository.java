package org.cunoc.cc4.repository;

import org.cunoc.cc4.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {

    boolean existsByName(String name);
}
