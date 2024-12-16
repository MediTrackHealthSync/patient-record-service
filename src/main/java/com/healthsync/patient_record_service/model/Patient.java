package com.healthsync.patient_record_service.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@Data
@Document(collection = "patients")
public class Patient {

    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private String contactNumber;
    private String address;
    private List<String> medicalHistory;
    private List<String> prescriptions;
    private List<String> labResults;

}
