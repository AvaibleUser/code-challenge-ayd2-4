package org.cunoc.cc4.service;

import java.util.List;
import java.util.Optional;

import org.cunoc.cc4.dto.AddDriverDto;
import org.cunoc.cc4.dto.DriverDto;
import org.cunoc.cc4.dto.PutDriverDto;
import org.cunoc.cc4.entity.DriverEntity;
import org.cunoc.cc4.exception.RequestConflictException;
import org.cunoc.cc4.exception.ValueNotFoundException;
import org.cunoc.cc4.repository.DriverRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DriverService implements IDriverService {

    private DriverRepository driverRepository;

    @Override
    public List<DriverDto> findAll() {
        return driverRepository.findAllDrivers();
    }

    @Override
    public Optional<DriverDto> findOne(long id) {
        return driverRepository.findDriverById(id);
    }

    @Override
    public void add(AddDriverDto newDriver) {
        if (driverRepository.existsByName(newDriver.name())) {
            throw new RequestConflictException("The name already exists");
        }
        driverRepository.save(new DriverEntity(newDriver.name(), newDriver.age()));
    }

    @Override
    public void update(long driverId, PutDriverDto updDriver) {
        DriverEntity driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new ValueNotFoundException("The driver was not found"));

        driver.setAge(updDriver.age());

        driverRepository.save(driver);
    }

    @Override
    public void delete(long driverId) {
        driverRepository.deleteById(driverId);
    }
}
