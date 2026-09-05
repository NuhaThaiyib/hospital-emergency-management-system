package datastructures;

import model.TreatmentRecord;
import model.TreatmentStackNode;

public class TreatmentStack {
    private TreatmentStackNode top;

    public TreatmentStack() {
        top = null;
    }

    // Push - add a completed treatment record
    public void push(TreatmentRecord treatment) {
        TreatmentStackNode newNode = new TreatmentStackNode(treatment);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record pushed for: " + treatment.getPatientName());
    }

    // Pop - remove and return the most recently completed treatment
    public TreatmentRecord pop() {
        if (top == null) {
            System.out.println("No treatment records to remove. Stack is empty.");
            return null;
        }

        TreatmentRecord removed = top.treatment;
        top = top.next;
        return removed;
    }

    // Display treatment records, most recent first
    public void display() {
        if (top == null) {
            System.out.println("No treatment records available.");
            return;
        }

        System.out.println("=== Treatment History (most recent first) ===");
        TreatmentStackNode current = top;
        while (current != null) {
            System.out.println(current.treatment);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}