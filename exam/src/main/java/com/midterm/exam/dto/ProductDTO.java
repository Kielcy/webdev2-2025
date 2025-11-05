package com.midterm.exam.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Brand is required")
        String brand,

        @Min(value = 0, message = "Price must be greater than or equal to 0")
        double price,

        @NotBlank(message = "Category is required")
        String category
) {}

