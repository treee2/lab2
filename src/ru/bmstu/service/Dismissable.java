package ru.bmstu.service;

import ru.bmstu.domain.Person;
import ru.bmstu.domain.Student;

public interface Dismissable {
    default void dismiss(Person p) {
        if (p instanceof Student) {
            Student student = (Student) p;
            System.out.println(student.getFirstName() + "   "  + student.getSecondName() + "   "+ student.getGroup());
        } else {
            System.out.println(p.getFirstName() + "   "  + p.getSecondName());
        }
    }
}
