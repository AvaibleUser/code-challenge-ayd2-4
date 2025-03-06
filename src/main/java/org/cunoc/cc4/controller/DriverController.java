package org.cunoc.cc4.controller;

import java.util.List;

import org.cunoc.cc4.dto.AddDriverDto;
import org.cunoc.cc4.dto.DriverDto;
import org.cunoc.cc4.dto.PutDriverDto;
import org.cunoc.cc4.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/driver")
@AllArgsConstructor
public class DriverController {

    private DriverService driverService;

    @GetMapping
    public List<DriverDto> getAll() {
        return driverService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid AddDriverDto driver) {
        driverService.add(driver);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable @Positive long id, @RequestBody @Valid PutDriverDto inDriver) {
        
    }
}
