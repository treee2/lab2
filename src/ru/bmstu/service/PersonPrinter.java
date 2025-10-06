package ru.bmstu.service;

import ru.bmstu.domain.Person;

public final class PersonPrinter {
    public static void printFI(Person person) {
        System.out.println(person.getFirstName() + "  " +  person.getSecondName());
    }

    public static void printInfo(Person person) {
        System.out.println(person.getFirstName() + "  " +  person.getSecondName() + "  " + person.getPhone() + "  " + person.getAge());
    }


}
