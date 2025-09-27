package ru.bmstu.service;

import ru.bmstu.domain.Person;
import ru.bmstu.domain.Student;

public interface Dismissable {
    default void dismiss(Person p) {
        System.out.println(p.getName() + "   " + p.getSurname());
    }
}
