package com.kalyan.patientservice.service;

import com.kalyan.patientservice.dto.PatientRequestDTO;
import com.kalyan.patientservice.dto.PatientResponseDTO;
import com.kalyan.patientservice.exception.EmailAlreadyExistException;
import com.kalyan.patientservice.mapper.PatientMapper;
import com.kalyan.patientservice.model.Patient;
import com.kalyan.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        //List<PatientResponseDTO> patientResponseDTOS = patients.stream().map(patient-> PatientMapper.toDTO(patient)).toList();
        return patients.stream().map(PatientMapper::toDTO).toList();

    }

    public PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO) {
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistException("This is is already used" + patientRequestDTO.getEmail());
        }
        Patient newPatient = patientRepository.save(PatientMapper.toEntity(patientRequestDTO));

        return PatientMapper.toDTO(newPatient);



    }

}
