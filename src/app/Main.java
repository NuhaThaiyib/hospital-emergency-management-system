package app;

import datastructures.PatientBST;
import datastructures.EmergencyQueue;
import model.Patient;

public class Main {
    public static void main(String[] args) {
        PatientBST patientTree = new PatientBST();

        // Insert some patients
        patientTree.insert(new Patient(101, "Amal Perera", 45, "0771234567", "Chest pain"));
        patientTree.insert(new Patient(105, "Nimal Silva", 30, "0777654321", "Fracture"));
        patientTree.insert(new Patient(103, "Kamala Fernando", 60, "0712345678", "Diabetes"));
        patientTree.insert(new Patient(110, "Sunil Bandara", 25, "0765432109", "Allergy"));

        System.out.println("=== All patients (ascending by ID) ===");
        patientTree.displayInOrder();

        System.out.println("\n=== Searching for Patient ID 103 ===");
        Patient found = patientTree.search(103);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Patient not found.");
        }

        System.out.println("\n=== Searching for Patient ID 999 (should not exist) ===");
        Patient notFound = patientTree.search(999);
        if (notFound != null) {
            System.out.println("Found: " + notFound);
        } else {
            System.out.println("Patient not found.");
        }

        System.out.println("\n=== Deleting Patient ID 103 ===");
        patientTree.delete(103);
        System.out.println("=== All patients after deletion ===");
        patientTree.displayInOrder();

        System.out.println("\n\n=== TESTING EMERGENCY QUEUE ===");
        EmergencyQueue emergencyQueue = new EmergencyQueue();

        emergencyQueue.enqueue(new Patient(201, "Saman Kumara", 22, "0711111111", "Broken arm"));
        emergencyQueue.enqueue(new Patient(202, "Priya Raj", 34, "0722222222", "High fever"));
        emergencyQueue.enqueue(new Patient(203, "Farah Ismail", 50, "0733333333", "Chest pain"));

        emergencyQueue.display();

        System.out.println("\n=== Treating next patient ===");
        Patient treated = emergencyQueue.dequeue();
        System.out.println("Now treating: " + treated);

        System.out.println("\n=== Queue after one dequeue ===");
        emergencyQueue.display();

        System.out.println("\n=== Emptying the queue completely ===");
        emergencyQueue.dequeue();
        emergencyQueue.dequeue();

        System.out.println("\n=== Trying to dequeue from an empty queue ===");
        emergencyQueue.dequeue();
    }
}