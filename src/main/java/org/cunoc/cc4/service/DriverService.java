package org.cunoc.cc4.service;

import java.util.List;

import org.cunoc.cc4.dto.AddDriverDto;
import org.cunoc.cc4.dto.DriverDto;
import org.cunoc.cc4.entity.DriverEntity;
import org.cunoc.cc4.exception.RequestConflictException;
import org.cunoc.cc4.repository.DriverRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DriverService {

    private DriverRepository driverRepository;

    public List<DriverDto> findAll() {
        return driverRepository.findAll()
                .stream()
                .map(d -> new DriverDto(d.getId(), d.getName(), d.getAge()))
                .toList();
    }

    public void add(AddDriverDto newDriver) {
        if (driverRepository.existsByName(newDriver.name())) {
            throw new RequestConflictException("The name already exists");
        }
        driverRepository.save(new DriverEntity(newDriver.name(), newDriver.age()));
    }
}
