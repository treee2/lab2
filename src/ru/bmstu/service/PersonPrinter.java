package ru.bmstu.service;

import ru.bmstu.domain.Person;

public final class PersonPrinter {


     // Выводит полную информацию о человеке в читаемом формате
    public static void printInfo(Person person) {
        System.out.println("  Имя: " + person.getFirstName() + " " + person.getSecondName());
        System.out.println("  Возраст: " + person.getAge() + " лет");

        // Красиво обрабатываем null телефон
        if (person.getPhone() != null && !person.getPhone().trim().isEmpty()) {
            System.out.println("  Телефон: " + person.getPhone());
        } else {
            System.out.println("  Телефон: не указан");
        }
    }

    // Выводит только ФИО (для совместимости со старым кодом)
    public static void printFI(Person person) {
        System.out.println(person.getFirstName() + " " + person.getSecondName());
    }
}