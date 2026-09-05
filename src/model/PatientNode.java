package model;

public class PatientNode {
    public Patient patient;
    public PatientNode left;
    public PatientNode right;

    public PatientNode(Patient patient) {
        this.patient = patient;
        this.left = null;
        this.right = null;
    }
}