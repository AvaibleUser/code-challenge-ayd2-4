package org.cunoc.cc4.repository;

import java.util.List;
import java.util.Optional;

import org.cunoc.cc4.dto.DriverDto;
import org.cunoc.cc4.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {

    List<DriverDto> findAllDrivers();

    Optional<DriverDto> findDriverById(long id);

    boolean existsByName(String name);
}
