package com.service;

import com.model.Student;
import com.repository.StudentRepository;
import java.util.List;

public class StudentService {
    private StudentRepository repository = new StudentRepository();

    public void addStudent(int id, String name, int age) {
        repository.addStudent(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }

    public void displayStudents() {
        List<Student> students = repository.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void updateStudent(int id, String name, int age) {
        if (repository.updateStudent(id, name, age)) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void deleteStudent(int id) {
        if (repository.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
}
