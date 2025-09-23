package ru.bmstu.service;

import ru.bmstu.domain.Person;
import ru.bmstu.domain.Student;

public class PersonDemo {
    private Person person;
    private Student student;

    public PersonDemo() {
        this.person = new Person("якоб", "джугашвилли", 17, "+7-123-456-78-90");
        this.student = new Student("Петр", "Петров", 35, "+7-777-888-99-00",
                "МК", 6);

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
        person2.setPhone("+7-987-654-32-10");

        PersonPrinter.printFI(person2);
        PersonPrinter.printInfo(person2);
        System.out.println();

        Student student = new Student("Мария", "Сидорова", 20, "+7-555-123-45-67", "ИУ7", 3);

        System.out.println("Объект Student:");
        PersonPrinter.printFI(student);
        PersonPrinter.printInfo(student);
        System.out.println();


        Student student3 = new Student("Алексей", "Смирнов", 21, "+7-987-654-32-10", "MK4", 4);
        System.out.println("==== Интерфейс =====\n");
        student3.dismiss(student3);

        Student student4 = new Student("Макар", "Смирнов", 21, "+7-987-654-32-10", "MK6", 1);
        StudentDismisser studentDismisser = new StudentDismisser();
        studentDismisser.dismiss(student4);

    }
}
