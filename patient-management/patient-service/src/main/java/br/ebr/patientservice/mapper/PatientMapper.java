package br.ebr.patientservice.mapper;

import br.ebr.patientservice.dto.PatientRequestDTO;
import br.ebr.patientservice.dto.PatientResponseDTO;
import br.ebr.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient) {
        return new PatientResponseDTO(patient.getId().toString(),
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth().toString());
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO) {
        Patient newPatient = new Patient();
        newPatient.setName(patientRequestDTO.name());
        newPatient.setAddress(patientRequestDTO.address());
        newPatient.setEmail(patientRequestDTO.email());
        newPatient.setDateOfBirth(LocalDate.parse(patientRequestDTO.dateOfBirth()));
        newPatient.setRegisteredDate(LocalDate.parse(patientRequestDTO.registeredDate()));
        return newPatient;
    }

}
