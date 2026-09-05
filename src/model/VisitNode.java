package model;

public class VisitNode {
    public Visit visit;
    public VisitNode next;

    public VisitNode(Visit visit) {
        this.visit = visit;
        this.next = null;
    }
}