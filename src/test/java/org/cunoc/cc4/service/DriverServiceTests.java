package org.cunoc.cc4.service;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.BDDAssertions;
import org.cunoc.cc4.dto.AddDriverDto;
import org.cunoc.cc4.dto.DriverDto;
import org.cunoc.cc4.entity.DriverEntity;
import org.cunoc.cc4.exception.RequestConflictException;
import org.cunoc.cc4.repository.DriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DriverServiceTests {

    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private DriverService driverService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void canFindAll() {
        // given
        DriverDto expectedDriver = new DriverDto(200L, "Random", 50);
        BDDMockito.given(driverRepository.findAllDrivers()).willReturn(List.of(expectedDriver));

        // when
        List<DriverDto> actualDriver = driverService.findAll();

        // then
        BDDAssertions.then(actualDriver).containsExactly(new DriverDto(200L, "Random", 50));
    }

    @Test
    void canFindOne_Existent() {
        // given
        long id = 500L;
        DriverDto expectedDriver = new DriverDto(id, "Random", 20);
        BDDMockito.given(driverRepository.findDriverById(id)).willReturn(Optional.of(expectedDriver));

        // when
        Optional<DriverDto> actualDriver = driverService.findOne(id);

        // then
        BDDAssertions.then(actualDriver).contains(new DriverDto(id, "Random", 20));
    }

    @Test
    void canFindOne_NonExistent() {
        // given
        long id = 10L;
        BDDMockito.given(driverRepository.findDriverById(id)).willReturn(Optional.empty());

        // when
        Optional<DriverDto> actualDriver = driverService.findOne(id);

        // then
        BDDAssertions.then(actualDriver).isEmpty();
    }

    @Test
    void canAdd() {
        // given
        String name = "Random";
        int age = 50;
        DriverEntity expectedDriver = new DriverEntity(name, age);
        AddDriverDto inputDriver = new AddDriverDto(name, age);
        BDDMockito.given(driverRepository.existsByName(name)).willReturn(false);

        // when
        driverService.add(inputDriver);

        // then
        BDDMockito.then(driverRepository).should().existsByName(name);
        BDDMockito.then(driverRepository).should().save(expectedDriver);
    }

    @Test
    void canAdd_WithAlreadyExistentName() {
        // given
        String name = "Random";
        int age = 50;
        DriverEntity expectedDriver = new DriverEntity(name, age);
        AddDriverDto inputDriver = new AddDriverDto(name, age);
        BDDMockito.given(driverRepository.existsByName(name)).willReturn(false);

        // when
        BDDAssertions.catchThrowableOfType(RequestConflictException.class, () -> driverService.add(inputDriver));

        // then
        BDDMockito.then(driverRepository).should().existsByName(name);
        BDDMockito.then(driverRepository).should().save(expectedDriver);
    }
}
