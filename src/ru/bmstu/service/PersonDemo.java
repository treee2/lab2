package ru.bmstu.service;

import ru.bmstu.domain.Person;
import ru.bmstu.domain.Student;
import ru.bmstu.exception.InvalidPhoneNumberException;
import java.util.List;

public class PersonDemo {
    private Person person;

    public PersonDemo() {
        this.person = new Person("якоб", "джугашвилли", 17, "+7-123-456-78-90");
        //Student student = new Student("Петр", "Петров", 35, "+7-777-888-99-00", "МК", 6);

    }

    public void demo() {
        System.out.println("=== Демонстрация работы PersonPrinter ===");
        System.out.println();


        // Демонстрируем работу с первым объектом (с телефоном)
        System.out.println("Объект 1 (с телефоном):");
        PersonPrinter.printFI(person);
        PersonPrinter.printInfo(person);
        System.out.println();

        // Создаем второй объект без телефона
        Person person2 = new Person("Анна", "Петрова", 30);
        System.out.println("Объект 2 (без телефона):");
        PersonPrinter.printFI(person2);
        PersonPrinter.printInfo(person2);
        System.out.println();

        // Демонстрируем работу сеттеров
        System.out.println("=== Демонстрация сеттеров ===");
        System.out.println("Изменяем возраст и добавляем телефон для объекта 2:");
        person2.setAge(31);
        try {
            person2.setPhone("+7-к987-654-32-10");
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Ошибка при установке телефона: " + e.getMessage());
        }
        try {
            person2.setPhone("+7-987-654-32-10");
        } catch (InvalidPhoneNumberException e) {
            System.out.println("шибка при установке телефона: " + e.getMessage());
        }

        PersonPrinter.printFI(person2);
        PersonPrinter.printInfo(person2);
        System.out.println();

        Student student = new Student("Мария", "Сидорова", 20, "+7-555-123-45-67", "ИУ7", 3);

        System.out.println("Объект Student:");
        PersonPrinter.printFI(student);
        PersonPrinter.printInfo(student);
        System.out.println();


        Student student3 = new Student("Алексей", "Смирнов", 21, "+7-987-654-32-10", "MK4", 4);
        System.out.println("==== Интерфейс Dismissable через переопределение в StudentDismisser =====\n");
        StudentDismisser st = new StudentDismisser();
        st.dismiss(student3);
        // простой человек \
        Person perl = new Person("Геннадий", "Ермаков", 33, "+7-987-654-32-10");
        st.dismiss(perl);

        Student student4 = new Student("Макар", "Смирнов", 21, "+7-987-654-32-10", "MK6", 1);
        StudentDismisser studentDismisser = new StudentDismisser();

        demonstrateNewFeatures();
    }


    public void demonstrateNewFeatures() {
        System.out.println(" Новые возможности LAB3");
        System.out.println();

        // Создаем студентов с дисциплинами
        Student student1 = new Student("Алексей", "Петров", 20, "+7-123-456-78-90", "ИУ7", 3);
        student1.addSubject("Математика", 5);
        student1.addSubject("Физика", 4);
        student1.addSubject("Программирование", 5);
        student1.addSubject("Английский", 3);

        Student student2 = new Student("Мария", "Иванова", 19, "+7-987-654-32-10", "ИУ6", 2);
        student2.addSubject("Математика", 4);
        student2.addSubject("Химия", 5);
        student2.addSubject("Биология", 4);

        Student student3 = new Student("Дмитрий", "Сидоров", 21, "+7-555-123-45-67", "ИУ8", 4);
        student3.addSubject("Математика", 5);
        student3.addSubject("Физика", 5);
        student3.addSubject("Программирование", 5);
        student3.addSubject("Алгоритмы", 5);
        student3.addSubject("Базы данных", 4);

        // выводим StudentPrinter
        System.out.println(" Демонстрация StudentPrinter");
        StudentPrinter.printStudentInfo(student1);
        StudentPrinter.printStudentInfo(student2);
        StudentPrinter.printStudentInfo(student3);

        // выводим StudentManager
        System.out.println(" Демонстрация StudentManager");
        StudentManager manager = new StudentManager();
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        manager.printAllStudents();

        // Поиск студента по имени
        System.out.println(" Поиск студента по имени");
        Student found = manager.findByName("Мария");
        if (found != null) {
            System.out.println("Найден студент: " + found.getFirstName() + " " + found.getSecondName());
            StudentPrinter.printSubjects(found);
        }

        // Поиск студентов с высоким средним баллом
        System.out.println(" Студенты со средним баллом >= 4.5");
        List<Student> highAchievers = manager.findByAverageGrade(4.5);
        for (Student s : highAchievers) {
            System.out.println(s.getFirstName() + " " + s.getSecondName() + " - средний балл: " + String.format("%.2f", s.getAverageGrade()));
        }
        System.out.println();

        // Удаление студента
        System.out.println(" Удаление студента");
        manager.removeStudent("Дмитрий");
        manager.printAllStudents();

        // показываем сортировку дисциплин
        System.out.println(" Демонстрация сортировки дисциплин");
        Student testStudent = new Student("Тест", "Тестов", 20, "+7-111-222-33-44", "ТЕСТ", 1);
        testStudent.addSubject("Алгебра", 4);
        testStudent.addSubject("Геометрия", 5);
        testStudent.addSubject("Биология", 3);
        testStudent.addSubject("Физика", 4);
        testStudent.addSubject("Химия", 5);

        System.out.println("Дисциплины в обратном алфавитном порядке:");
        StudentPrinter.printSubjects(testStudent);
    }
}

