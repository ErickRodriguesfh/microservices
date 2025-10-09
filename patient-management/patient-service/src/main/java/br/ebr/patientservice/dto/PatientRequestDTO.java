package br.ebr.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PatientRequestDTO(
        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name cannot exceed 100 characters")
        String name,

        @NotBlank(message = "E-mail is required")
        @Email
        String email,

        @NotBlank(message = "Date of birth is required")
        String dateOfBirth,

        @NotNull(message = "Registered date is required")
        String registeredDate,

        @NotBlank(message = "Address is required")
        String address
) {
}
