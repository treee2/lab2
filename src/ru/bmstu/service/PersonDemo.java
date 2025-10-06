package ru.bmstu.service;

import java.util.List;
import ru.bmstu.domain.Person;
import ru.bmstu.domain.Student;
import ru.bmstu.exception.InvalidPhoneNumberException;

public class PersonDemo {

    public void demo() {
        // 1. Демонстрация базового класса Person
        demonstratePersonClass();

        // 2. Демонстрация обработки исключений
        demonstrateExceptionHandling();

        // 3. Демонстрация класса Student с дисциплинами
        demonstrateStudentClass();

        // 4. Демонстрация интерфейса Dismissable
        demonstrateDismissable();

        // 5. Демонстрация StudentManager
        demonstrateStudentManager();

        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА                     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    /**
     * 1. ДЕМОНСТРАЦИЯ БАЗОВОГО КЛАССА PERSON
     * Показывает: создание объектов, работу конструкторов, геттеры/сеттеры
     */
    private void demonstratePersonClass() {
        printSection("1. БАЗОВЫЙ КЛАСС PERSON");

        // Создание с телефоном
        Person person1 = new Person("Иван", "Иванов", 25, "+7-123-456-78-90");
        System.out.println("✓ Создан Person с телефоном:");
        PersonPrinter.printInfo(person1);

        // Создание без телефона
        Person person2 = new Person("Анна", "Петрова", 30);
        System.out.println("\n✓ Создан Person без телефона:");
        PersonPrinter.printInfo(person2);

        // Демонстрация сеттеров
        System.out.println("\n✓ Изменяем возраст и добавляем телефон:");
        person2.setAge(31);
        try {
            person2.setPhone("+7-987-654-32-10");
            PersonPrinter.printInfo(person2);
        } catch (InvalidPhoneNumberException e) {
            System.out.println("⚠ Ошибка: " + e.getMessage());
        }

        System.out.println();
    }

    /**
     * 2. ДЕМОНСТРАЦИЯ ОБРАБОТКИ ИСКЛЮЧЕНИЙ
     * Показывает: валидацию телефонных номеров, обработку ошибок
     */
    private void demonstrateExceptionHandling() {
        printSection("2. ОБРАБОТКА ИСКЛЮЧЕНИЙ (валидация телефона)");

        Person person = new Person("Тест", "Тестов", 20);

        // Тест 1: Буквы в номере
        testPhoneNumber(person, "invalid-phone", "содержит буквы");

        // Тест 2: Слишком короткий
        testPhoneNumber(person, "123", "слишком короткий (< 10 цифр)");

        // Тест 3: Пустой номер
        testPhoneNumber(person, "", "пустая строка");

        // Тест 4: Корректный номер
        testPhoneNumber(person, "+7-999-888-77-66", "корректный номер ✓");

        System.out.println();
    }

    /**
     * 3. ДЕМОНСТРАЦИЯ КЛАССА STUDENT
     * Показывает: наследование, дисциплины, сортировку, средний балл
     */
    private void demonstrateStudentClass() {
        printSection("3. КЛАСС STUDENT (наследник Person)");

        Student student = new Student("Мария", "Сидорова", 20,
                "+7-555-123-45-67", "ИУ7", 3);

        // Добавляем дисциплины в случайном порядке
        System.out.println("✓ Добавляем дисциплины в случайном порядке:");
        System.out.println("  → Математика, Алгебра, Физика, Геометрия, Биология");
        student.addSubject("Математика", 5);
        student.addSubject("Алгебра", 4);
        student.addSubject("Физика", 5);
        student.addSubject("Геометрия", 4);
        student.addSubject("Биология", 3);

        System.out.println("\n✓ Список автоматически отсортирован (Я→А):");
        StudentPrinter.printStudentInfo(student);
    }

    /**
     * 4. ДЕМОНСТРАЦИЯ ИНТЕРФЕЙСА DISMISSABLE
     * Показывает: default-метод и переопределение
     */
    private void demonstrateDismissable() {
        printSection("4. ИНТЕРФЕЙС DISMISSABLE");

        Student student1 = new Student("Алексей", "Смирнов", 21,
                "+7-987-654-32-10", "МК-4", 4);

        // Default-реализация
        System.out.println("✓ Default-метод интерфейса:");
        Dismissable defaultImpl = student1;
        defaultImpl.dismiss(student1);

        // Переопределенная реализация
        System.out.println("\n✓ Переопределенный метод (StudentDismisser):");
        StudentDismisser dismisser = new StudentDismisser();
        dismisser.dismiss(student1);

        System.out.println();
    }

    /**
     * 5. ДЕМОНСТРАЦИЯ STUDENTMANAGER
     * Показывает: CRUD операции, поиск, фильтрацию
     */
    private void demonstrateStudentManager() {
        printSection("5. STUDENTMANAGER (управление коллекцией)");

        StudentManager manager = new StudentManager();

        // Создаем студентов
        Student s1 = createStudentWithGrades("Алексей", "Петров", "ИУ7", 3,
                new String[]{"Математика", "Физика", "Программирование"},
                new int[]{5, 4, 5});
        Student s2 = createStudentWithGrades("Мария", "Иванова", "ИУ6", 2,
                new String[]{"Математика", "Химия"},
                new int[]{4, 5});
        Student s3 = createStudentWithGrades("Дмитрий", "Сидоров", "ИУ8", 4,
                new String[]{"Алгоритмы", "БД", "Программирование"},
                new int[]{5, 4, 5});

        // Добавление
        System.out.println("✓ Добавлено 3 студента:");
        manager.addStudent(s1);
        manager.addStudent(s2);
        manager.addStudent(s3);
        manager.printAllStudents();

        // Поиск по имени
        System.out.println("✓ Поиск студента 'Мария':");
        Student found = manager.findByName("Мария");
        if (found != null) {
            System.out.println("  Найдена: " + found.getFirstName() + " " +
                    found.getSecondName() + " (средний балл: " +
                    String.format("%.2f", found.getAverageGrade()) + ")");
        }

        // Поиск по среднему баллу
        System.out.println("\n✓ Студенты со средним баллом ≥ 4.5:");
        List<Student> highAchievers = manager.findByAverageGrade(4.5);
        for (Student s : highAchievers) {
            System.out.println("  • " + s.getFirstName() + " " + s.getSecondName() +
                    " - " + String.format("%.2f", s.getAverageGrade()));
        }

        // Удаление
        System.out.println("\n✓ Удаляем студента 'Дмитрий':");
        manager.removeStudent("Дмитрий");
        System.out.println("\nОсталось студентов: " + manager.getStudentCount());
        manager.printAllStudents();
    }

    // ============== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ==============

    private void printSection(String title) {
        System.out.println("┌────────────────────────────────────────────────────────────────┐");
        System.out.println("│ " + title);
        System.out.println("└────────────────────────────────────────────────────────────────┘");
    }

    private void testPhoneNumber(Person person, String phone, String description) {
        try {
            person.setPhone(phone);
            System.out.println("  ✓ \"" + phone + "\" - " + description);
        } catch (InvalidPhoneNumberException e) {
            System.out.println("  ✗ \"" + phone + "\" - " + description +
                    " → " + e.getMessage());
        }
    }

    private Student createStudentWithGrades(String firstName, String lastName,
                                            String group, int course,
                                            String[] subjects, int[] grades) {
        Student student = new Student(firstName, lastName, 20,
                "+7-111-222-33-44", group, course);
        for (int i = 0; i < subjects.length; i++) {
            student.addSubject(subjects[i], grades[i]);
        }
        return student;
    }
}