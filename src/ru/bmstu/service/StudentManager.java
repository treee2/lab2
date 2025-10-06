package ru.bmstu.service;

import java.util.ArrayList;
import java.util.List;
import ru.bmstu.domain.Student;

public class StudentManager {
    private ArrayList<Student> students;
    
    public StudentManager() {
        this.students = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public Student findByName(String name) {
        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(name) || 
                student.getSecondName().equalsIgnoreCase(name) ||
                (student.getFirstName() + " " + student.getSecondName()).equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }
    
    public List<Student> findByAverageGrade(double minAverage) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getAverageGrade() >= minAverage) {
                result.add(student);
            }
        }
        return result;
    }
    
    public void removeStudent(String name) {
        Student studentToRemove = findByName(name);
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Студент " + name + " удален из списка");
        } else {
            System.out.println("Студент " + name + " не найден");
        }
    }
    
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    
    public int getStudentCount() {
        return students.size();
    }
    
    public void printAllStudents() {
        System.out.println("=== Список всех студентов ===");
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i).getFirstName() + " " + 
                                 students.get(i).getSecondName() + " (Группа: " + 
                                 students.get(i).getGroup() + ", Курс: " + 
                                 students.get(i).getCourse() + ")");
            }
        }
        System.out.println();
    }
}
