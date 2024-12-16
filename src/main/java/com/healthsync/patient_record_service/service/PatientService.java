package com.healthsync.patient_record_service.service;

import com.healthsync.patient_record_service.model.Patient;

import java.util.List;

public interface PatientService {
    Patient createPatient(Patient patient);
    Patient getPatientById(String id);
    List<Patient> getAllPatients();
    Patient updatePatient(String id, Patient patient);
    void deletePatient(String id);
}
