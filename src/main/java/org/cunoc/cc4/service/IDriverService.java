package org.cunoc.cc4.service;

import java.util.List;
import java.util.Optional;

import org.cunoc.cc4.dto.AddDriverDto;
import org.cunoc.cc4.dto.DriverDto;

public interface IDriverService {

    List<DriverDto> findAll();

    Optional<DriverDto> findOne(long id);

    void add(AddDriverDto newDriver);
}
