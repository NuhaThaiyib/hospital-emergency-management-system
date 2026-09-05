package model;

public class TreatmentRecord {
    private int patientId;
    private String patientName;
    private String treatmentDetails;

    public TreatmentRecord(int patientId, String patientName, String treatmentDetails) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentDetails = treatmentDetails;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
               ", Name: " + patientName +
               ", Treatment: " + treatmentDetails;
    }
}