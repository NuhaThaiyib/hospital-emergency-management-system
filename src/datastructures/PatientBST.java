package datastructures;

import model.Patient;
import model.PatientNode;

public class PatientBST {
    private PatientNode root;

    public PatientBST() {
        root = null;
    }

    // Insert a new patient
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private PatientNode insertRec(PatientNode current, Patient patient) {
        if (current == null) {
            return new PatientNode(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRec(current.left, patient);
        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRec(current.right, patient);
        } else {
            System.out.println("Patient ID " + patient.getPatientId() + " already exists.");
        }

        return current;
    }

    // Search for a patient by ID
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(PatientNode current, int patientId) {
        if (current == null) {
            return null;
        }
        if (patientId == current.patient.getPatientId()) {
            return current.patient;
        } else if (patientId < current.patient.getPatientId()) {
            return searchRec(current.left, patientId);
        } else {
            return searchRec(current.right, patientId);
        }
    }

    // In-order traversal: prints patients in ascending order of ID
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patients in the system.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(PatientNode current) {
        if (current != null) {
            inOrderRec(current.left);
            System.out.println(current.patient);
            inOrderRec(current.right);
        }
    }
    // Delete a patient by ID
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private PatientNode deleteRec(PatientNode current, int patientId) {
        if (current == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return null;
        }

        if (patientId < current.patient.getPatientId()) {
            current.left = deleteRec(current.left, patientId);
        } else if (patientId > current.patient.getPatientId()) {
            current.right = deleteRec(current.right, patientId);
        } else {
            // Found the node to delete

            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: one child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // Case 3: two children
            // Find the smallest value in the right subtree
            Patient smallestInRight = findMin(current.right);
            current.patient = smallestInRight;
            // Delete that smallest value from the right subtree
            current.right = deleteRec(current.right, smallestInRight.getPatientId());
        }

        return current;
    }

    private Patient findMin(PatientNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.patient;
    }
}
