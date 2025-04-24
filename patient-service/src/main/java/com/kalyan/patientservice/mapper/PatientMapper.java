package com.kalyan.patientservice.mapper;

import com.kalyan.patientservice.dto.PatientRequestDTO;
import com.kalyan.patientservice.dto.PatientResponseDTO;
import com.kalyan.patientservice.model.Patient;

import java.time.LocalDateTime;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        return patientDTO;

    }

    public static Patient toEntity(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDateTime.parse(patientRequestDTO.getDateOfBirth().toString()));
        patient.setregistered_date(LocalDateTime.parse((patientRequestDTO.getRegisteredDate().toString())));
        return patient;

    }
}
