package org.cunoc.cc4.dto;

import jakarta.validation.constraints.Min;

public record PutDriverDto(
        @Min(18) Integer age) {
}
