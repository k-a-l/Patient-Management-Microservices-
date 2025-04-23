package com.kalyan.patientservice.controller;

import com.kalyan.patientservice.dto.PatientRequestDTO;
import com.kalyan.patientservice.dto.PatientResponseDTO;
import com.kalyan.patientservice.model.Patient;
import com.kalyan.patientservice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> findAll(){
       List<PatientResponseDTO> patients= patientService.getPatients();
       return ResponseEntity.ok().body(patients);
    }
    @PostMapping("/add")
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO newPatient= patientService.addPatient(patientRequestDTO);
        return ResponseEntity.ok().body(newPatient);
        //return  ResponseEntity.ok().body(patientService.addPatient(patientRequestDTO));
    }


}
