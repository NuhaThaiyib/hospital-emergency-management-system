package model;

import datastructures.VisitHistory;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String contactNumber;
    private String medicalCondition;
    private VisitHistory visitHistory = new VisitHistory();

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public VisitHistory getVisitHistory() {
        return visitHistory;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
               ", Name: " + name +
               ", Age: " + age +
               ", Contact: " + contactNumber +
               ", Condition: " + medicalCondition;
    }
}