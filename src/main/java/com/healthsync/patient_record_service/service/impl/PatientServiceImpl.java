package com.healthsync.patient_record_service.service.impl;

import com.healthsync.patient_record_service.model.Patient;
import com.healthsync.patient_record_service.repository.PatientRepository;
import com.healthsync.patient_record_service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(String id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(String id, Patient patient) {
        Patient existingPatient = getPatientById(id);
        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setContactNumber(patient.getContactNumber());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setMedicalHistory(patient.getMedicalHistory());
        existingPatient.setPrescription(patient.getPrescription());
        existingPatient.setLabTest(patient.getLabTest());
        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}
