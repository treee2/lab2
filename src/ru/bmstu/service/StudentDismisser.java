package ru.bmstu.service;

import ru.bmstu.domain.Person;
import ru.bmstu.domain.Student;

public class StudentDismisser implements Dismissable {
    @Override
    public void dismiss(Person p) {
        if (p instanceof Student) {
            Student student = (Student) p;
            System.out.println("Полная информация о студенте:");
            System.out.println("Имя: " + student.getFirstName());
            System.out.println("Фамилия: " + student.getSecondName());
            System.out.println("Возраст: " + student.getAge());
            System.out.println("Телефон: " + student.getPhone());
            System.out.println("Группа: " + student.getGroup());
            System.out.println("Курс: " + student.getCourse());
        } else {
            System.out.println("Полная информация о человеке:");
            System.out.println("Имя: " + p.getFirstName());
            System.out.println("Фамилия: " + p.getSecondName());
            System.out.println("Возраст: " + p.getAge());
            System.out.println("Телефон: " + p.getPhone());
        }
    }
}
