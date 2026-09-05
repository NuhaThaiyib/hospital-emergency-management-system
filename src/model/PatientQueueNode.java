package model;

public class PatientQueueNode {
    public Patient patient;
    public PatientQueueNode next;

    public PatientQueueNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}