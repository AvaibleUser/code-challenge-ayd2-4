package org.cunoc.cc4.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddDriverDto(
        @NotBlank String name,
        @NotNull @Min(18) Integer age) {
}
