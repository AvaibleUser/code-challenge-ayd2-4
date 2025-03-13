package org.cunoc.cc4.controller;

import java.util.List;
import java.util.Optional;

import org.cunoc.cc4.dto.AddDriverDto;
import org.cunoc.cc4.dto.DriverDto;
import org.cunoc.cc4.dto.PutDriverDto;
import org.cunoc.cc4.service.IDriverService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    private IDriverService driverService;

    @GetMapping
    public List<DriverDto> getAll() {
        return driverService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DriverDto> get(@PathVariable @Positive long id) {
        return driverService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid AddDriverDto driver) {
        driverService.add(driver);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable @Positive long id, @RequestBody @Valid PutDriverDto inDriver) {
        driverService.update(id, inDriver);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive long id) {
        driverService.delete(id);
    }
}
