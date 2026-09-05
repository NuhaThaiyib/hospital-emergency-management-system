package datastructures;

import model.Patient;
import model.PatientQueueNode;

public class EmergencyQueue {
    private PatientQueueNode front;
    private PatientQueueNode rear;

    public EmergencyQueue() {
        front = null;
        rear = null;
    }

    // Enqueue - add a patient to the back of the queue
    public void enqueue(Patient patient) {
        PatientQueueNode newNode = new PatientQueueNode(patient);

        if (rear == null) {
            // Queue is empty, this is the only node
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Patient " + patient.getName() + " added to the emergency queue.");
    }

    // Dequeue - remove and return the patient at the front
    public Patient dequeue() {
        if (front == null) {
            System.out.println("The emergency queue is empty. No patients to treat.");
            return null;
        }

        Patient treatedPatient = front.patient;
        front = front.next;

        if (front == null) {
            // Queue became empty
            rear = null;
        }

        return treatedPatient;
    }

    // Display all patients currently waiting
    public void display() {
        if (front == null) {
            System.out.println("No patients currently waiting.");
            return;
        }

        System.out.println("=== Patients waiting in emergency queue ===");
        PatientQueueNode current = front;
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}