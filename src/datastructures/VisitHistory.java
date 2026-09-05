package datastructures;

import model.Visit;
import model.VisitNode;

public class VisitHistory {
    private VisitNode head;

    public VisitHistory() {
        head = null;
    }

    // Add a new visit to the end of the list
    public void addVisit(Visit visit) {
        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
        } else {
            VisitNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Visit added: " + visit.getVisitId());
    }

    // Remove a visit by Visit ID
    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visits to remove.");
            return;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit " + visitId + " removed.");
            return;
        }

        VisitNode current = head;
        while (current.next != null) {
            if (current.next.visit.getVisitId() == visitId) {
                current.next = current.next.next;
                System.out.println("Visit " + visitId + " removed.");
                return;
            }
            current = current.next;
        }

        System.out.println("Visit " + visitId + " not found.");
    }

    // Search for a visit by Visit ID
    public Visit searchVisit(int visitId) {
        VisitNode current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null;
    }

    // Display all visits
    public void display() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        VisitNode current = head;
        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }
}