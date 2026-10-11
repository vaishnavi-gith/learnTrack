package com.airtribe;

import com.airtribe.entity.course;
import com.airtribe.entity.enrollment;
import com.airtribe.entity.student;
import com.airtribe.exception.EntityNotFoundException;
import com.airtribe.service.courseService;
import com.airtribe.service.enrollmentService;
import com.airtribe.service.studentService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        studentService studentService = new studentService();
        courseService courseService = new courseService();
        enrollmentService enrollmentService = new enrollmentService(studentService, courseService);

        boolean running = true;

        while (running) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        // Add Student
                        System.out.print("Enter First Name: ");
                        String fName = scanner.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lName = scanner.nextLine();
                        System.out.print("Enter Batch (e.g., Cohort 1): ");
                        String batch = scanner.nextLine();
                        System.out.print("Enter Email (or press Enter to skip): ");
                        String email = scanner.nextLine();

                        student s;
                        if (email.isEmpty()) {
                            s = studentService.addStudent(fName, lName, batch);
                        } else {
                            s = studentService.addStudent(fName, lName, email, batch);
                        }
                        System.out.println("Student added successfully with ID: " + s.getId());
                        break;

                    case 2:
                        // View All Students
                        System.out.println("\n--- All Students ---");
                        for (student student : studentService.getAllStudents()) {
                            System.out.println("ID: " + student.getId() + " | Name: " + student.getDisplayName() +
                                    " | Batch: " + student.getBatch() + " | Active: " + student.isActive());
                        }
                        break;

                    case 3:
                        // Search Student by ID
                        System.out.print("Enter Student ID: ");
                        int sId = scanner.nextInt();
                        student found = studentService.findStudentById(sId);
                        System.out.println("Found: " + found.getDisplayName() + " | Email: " + found.getEmail());
                        break;

                    case 4:
                        // Deactivate Student
                        System.out.print("Enter Student ID to deactivate: ");
                        int decId = scanner.nextInt();
                        studentService.deactivateStudent(decId);
                        System.out.println("⚠Student " + decId + " has been deactivated.");
                        break;

                    case 5:
                        // Add Course
                        System.out.print("Enter Course Name: ");
                        String cName = scanner.nextLine();
                        System.out.print("Enter Description: ");
                        String desc = scanner.nextLine();
                        System.out.print("Enter Duration (in weeks): ");
                        int duration = scanner.nextInt();

                        course c = courseService.addCourse(cName, desc, duration);
                        System.out.println("Course added successfully with ID: " + c.getId());
                        break;

                    case 6:
                        // View All Courses
                        System.out.println("\n--- All Courses ---");
                        for (course course : courseService.getAllCourses()) {
                            System.out.println("ID: " + course.getId() + " | Name: " + course.getCourseName() +
                                    " | Duration: " + course.getDurationInWeeks() + "w | Active: " + course.isActive());
                        }
                        break;

                    case 7:
                        // Enroll Student in Course
                        System.out.print("Enter Student ID: ");
                        int estId = scanner.nextInt();
                        System.out.print("Enter Course ID: ");
                        int ecoId = scanner.nextInt();

                        enrollment en = enrollmentService.enrollStudent(estId, ecoId);
                        System.out.println("Successfully enrolled! Enrollment ID: " + en.getId());
                        break;

                    case 8:
                        // View Enrollments for Student
                        System.out.print("Enter Student ID: ");
                        int vstId = scanner.nextInt();
                        System.out.println("\n--- Enrollments for Student " + vstId + " ---");
                        for (enrollment e : enrollmentService.getEnrollmentsForStudent(vstId)) {
                            System.out.println("Enrollment ID: " + e.getId() + " | Course ID: " + e.getCourseId() +
                                    " | Date: " + e.getEnrollmentDate() + " | Status: " + e.getStatus());
                        }
                        break;

                    case 9:
                        // Exit
                        running = false;
                        System.out.println("Exiting LearnTrack. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid menu option. Please choose between 1 and 9.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number where expected.");
                scanner.nextLine(); // clear the invalid input buffer
            } catch (EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("==============================");
        System.out.println("    LEARNTRACK - MAIN MENU    ");
        System.out.println("==============================");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Deactivate Student");
        System.out.println("5. Add New Course");
        System.out.println("6. View All Courses");
        System.out.println("7. Enroll Student in Course");
        System.out.println("8. View Student Enrollments");
        System.out.println("9. Exit");
        System.out.print("Select an option (1-9): ");
    }

}