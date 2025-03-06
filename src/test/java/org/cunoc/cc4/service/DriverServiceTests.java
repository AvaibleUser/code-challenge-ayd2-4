package org.cunoc.cc4.service;

import java.util.List;

import org.assertj.core.api.BDDAssertions;
import org.cunoc.cc4.dto.DriverDto;
import org.cunoc.cc4.entity.DriverEntity;
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
        DriverEntity expectedDriver = new DriverEntity("Random", 50);
        BDDMockito.given(driverRepository.findAll()).willReturn(List.of(expectedDriver));

        // when
        List<DriverDto> actualDriver = driverService.findAll();

        // then
        BDDMockito.then(driverRepository).should().findAll();
        BDDAssertions.then(actualDriver).
    }
}
