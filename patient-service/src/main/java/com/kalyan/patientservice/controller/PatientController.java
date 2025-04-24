package com.kalyan.patientservice.controller;

import com.kalyan.patientservice.dto.PatientRequestDTO;
import com.kalyan.patientservice.dto.PatientResponseDTO;
import com.kalyan.patientservice.dto.validators.CreatePatientValidationGroup;
import com.kalyan.patientservice.model.Patient;
import com.kalyan.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name = "patients", description = "Patient Management System")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    @Operation(summary = "Get All Patients")
    public ResponseEntity<List<PatientResponseDTO>> findAll(){
       List<PatientResponseDTO> patients= patientService.getPatients();
       return ResponseEntity.ok().body(patients);
    }
    @PostMapping("/add")
    @Operation(summary = "Create new Patients")
    public ResponseEntity<PatientResponseDTO> createPatient
            (@Validated({Default.class, CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO newPatient= patientService.addPatient(patientRequestDTO);
        return ResponseEntity.ok().body(newPatient);
        //return  ResponseEntity.ok().body(patientService.addPatient(patientRequestDTO));
    }

    @PutMapping("/update/{id}")
    @Operation(summary= "Update Existing Patient")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO updatePatient= patientService.updatePatient(id,patientRequestDTO);
        return ResponseEntity.ok().body(updatePatient);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Patient")
    public ResponseEntity<PatientResponseDTO> deletePatient(@PathVariable UUID id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }



}
