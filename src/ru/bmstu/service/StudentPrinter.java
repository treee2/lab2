package ru.bmstu.service;

import ru.bmstu.domain.Student;
import ru.bmstu.domain.Subject;

public class StudentPrinter {
    
    public static void printStudentInfo(Student student) {
        System.out.println(" Информация о студенте ");
        System.out.println("Имя: " + student.getFirstName() + " " + student.getSecondName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Телефон: " + student.getPhone());
        System.out.println("Группа: " + student.getGroup());
        System.out.println("Курс: " + student.getCourse());
        System.out.println("Средний балл: " + String.format("%.2f", student.getAverageGrade()));
        
        System.out.println("\nДисциплины:");
        if (student.getSubjects().isEmpty()) {
            System.out.println("  Дисциплины не добавлены");
        } else {
            for (Subject subject : student.getSubjects()) {
                System.out.println("  " + subject);
            }
        }
        System.out.println();
    }
    
    public static void printSubjects(Student student) {
        System.out.println("Дисциплины студента " + student.getFirstName() + " " + student.getSecondName() + ":");
        if (student.getSubjects().isEmpty()) {
            System.out.println("  Дисциплины не добавлены");
        } else {
            for (Subject subject : student.getSubjects()) {
                System.out.println("  " + subject);
            }
        }
        System.out.println();
    }
}
