package org.cunoc.cc4.service;

import java.util.List;

import org.cunoc.cc4.dto.AddDriverDto;
import org.cunoc.cc4.dto.DriverDto;

public interface IDriverService {

    List<DriverDto> findAll();

    void add(AddDriverDto newDriver);
}
