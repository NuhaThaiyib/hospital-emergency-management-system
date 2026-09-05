package app;

import java.util.Scanner;
import datastructures.PatientBST;
import datastructures.EmergencyQueue;
import datastructures.TreatmentStack;
import model.Patient;
import model.TreatmentRecord;
import model.Visit;

public class Main {
    static PatientBST patientTree = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: addPatient(); break;
                case 2: searchPatient(); break;
                case 3: deletePatient(); break;
                case 4: patientTree.displayInOrder(); break;
                case 5: addToQueue(); break;
                case 6: treatNextPatient(); break;
                case 7: emergencyQueue.display(); break;
                case 8: completeTreatment(); break;
                case 9: viewLastTreatment(); break;
                case 10: treatmentStack.display(); break;
                case 11: addVisit(); break;
                case 12: viewVisitHistory(); break;
                case 0: System.out.println("Exiting system. Goodbye!"); break;
                default: System.out.println("Invalid choice, try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n=== MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM ===");
        System.out.println("1. Add New Patient");
        System.out.println("2. Search Patient by ID");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients (In-Order)");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. Treat Next Patient (Dequeue)");
        System.out.println("7. Display Emergency Queue");
        System.out.println("8. Complete Treatment (Push to Stack)");
        System.out.println("9. View/Remove Last Treatment (Pop from Stack)");
        System.out.println("10. Display Treatment History");
        System.out.println("11. Add Visit to Patient History");
        System.out.println("12. View Patient Visit History");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        patientTree.insert(new Patient(id, name, age, contact, condition));
        System.out.println("Patient added successfully.");
    }

    static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = Integer.parseInt(scanner.nextLine());
        Patient p = patientTree.search(id);
        System.out.println(p != null ? p : "Patient not found.");
    }

    static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        patientTree.delete(id);
    }

    static void addToQueue() {
        System.out.print("Enter Patient ID (must already exist): ");
        int id = Integer.parseInt(scanner.nextLine());
        Patient p = patientTree.search(id);
        if (p == null) {
            System.out.println("Patient not found. Add the patient first.");
        } else {
            emergencyQueue.enqueue(p);
        }
    }

    static void treatNextPatient() {
        Patient treated = emergencyQueue.dequeue();
        if (treated != null) {
            System.out.println("Now treating: " + treated);
        }
    }

    static void completeTreatment() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Patient p = patientTree.search(id);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter treatment details: ");
        String details = scanner.nextLine();
        treatmentStack.push(new TreatmentRecord(id, p.getName(), details));
    }

    static void viewLastTreatment() {
        TreatmentRecord record = treatmentStack.pop();
        System.out.println(record != null ? "Removed: " + record : "");
    }

    static void addVisit() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Patient p = patientTree.search(id);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter Visit ID: ");
        int visitId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        p.getVisitHistory().addVisit(new Visit(visitId, date, doctor, diagnosis, treatment));
    }

    static void viewVisitHistory() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Patient p = patientTree.search(id);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }
        p.getVisitHistory().display();
    }
}