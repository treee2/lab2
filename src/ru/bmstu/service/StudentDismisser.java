package ru.bmstu.service;


import ru.bmstu.domain.Student;

public class StudentDismisser implements Dismissable {
    public void demonstrateStudentDismisser() {
        System.out.println("=== Демонстрация класса StudentDismisser ===");
        System.out.println();

        // Создаем объект StudentDismisser
        StudentDismisser dismisser = new StudentDismisser();

        // Создаем студентов для тестирования
        Student student1 = new Student("Иван", "Иванов", 20, "+7-111-222-33-44", "ИУ7-31Б", 3);

        System.out.println("1. Отчисление студента с полной информацией:");
        dismisser.dismiss(student1);
        System.out.println();
    }
}
