package model;

public class TreatmentStackNode {
    public TreatmentRecord treatment;
    public TreatmentStackNode next;

    public TreatmentStackNode(TreatmentRecord treatment) {
        this.treatment = treatment;
        this.next = null;
    }
}