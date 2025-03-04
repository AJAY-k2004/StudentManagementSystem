package com.controller;

import com.service.StudentService;
import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent(service, scanner);
                    break;
                case 2:
                    service.displayStudents();
                    break;
                case 3:
                    updateStudent(service, scanner);
                    break;
                case 4:
                    deleteStudent(service, scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void addStudent(StudentService service, Scanner scanner) {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        service.addStudent(id, name, age);
    }

    private static void updateStudent(StudentService service, Scanner scanner) {
        System.out.print("Enter ID of student to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        service.updateStudent(id, name, age);
    }

    private static void deleteStudent(StudentService service, Scanner scanner) {
        System.out.print("Enter ID of student to delete: ");
        int id = scanner.nextInt();
        service.deleteStudent(id);
    }
}
