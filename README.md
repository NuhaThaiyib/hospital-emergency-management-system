# Mini Hospital Emergency Management System

A Java console application simulating hospital emergency operations — patient registration, emergency queue management, treatment history tracking, and patient visit records — built using core data structures implemented from scratch.

## Assignment
CIT300 - Data Structures and Algorithms, Individual Mid Assignment

## Data Structures Used

| Feature | Data Structure | Purpose |
|---|---|---|
| Patient Records | Binary Search Tree (BST) | Store and manage patients by Patient ID, allowing fast insert, search, delete, and ordered (in-order) display |
| Emergency Patient Queue | Queue (custom linked implementation) | Manage patients waiting for emergency treatment in FIFO order |
| Treatment History | Stack (custom linked implementation) | Track completed treatments in LIFO order, so the most recent treatment can be reviewed/removed first |
| Patient Visit History | Singly Linked List | Store each patient's past hospital visits individually |

## Project Structure
src/
├── app/
│ └── Main.java — Entry point, menu-driven interface
├── model/
│ ├── Patient.java — Patient data model
│ ├── PatientNode.java — Node used in the BST
│ ├── PatientQueueNode.java — Node used in the Emergency Queue
│ ├── TreatmentRecord.java — Treatment record data model
│ ├── TreatmentStackNode.java— Node used in the Treatment Stack
│ ├── Visit.java — Visit data model
│ └── VisitNode.java — Node used in the Visit History linked list
└── datastructures/
├── PatientBST.java — Binary Search Tree implementation
├── EmergencyQueue.java — Queue implementation
├── TreatmentStack.java — Stack implementation
└── VisitHistory.java — Singly Linked List implementation

## How to Run
1. Clone this repository.
2. Open the project in Eclipse (or any Java IDE).
3. Run `app/Main.java` as a Java Application.
4. Follow the on-screen menu to interact with the system.

## Features
- Add, search, delete, and display patients (BST, sorted by Patient ID)
- Add patients to the emergency queue and treat them in arrival order
- Record completed treatments and review/remove the most recent one
- Add, search, remove, and view a patient's individual visit history

## Author
Nuha Thaiyib
