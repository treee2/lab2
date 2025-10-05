package ru.bmstu.service;

import ru.bmstu.domain.Person;
import ru.bmstu.domain.Student;

public class StudentDismisser implements Dismissable {

    @Override
    public void dismiss(Person p) {
        if (p instanceof Student) {
            Student student = (Student) p;
            System.out.println("Отчисленный студент: " + student.getSurname() + " " + student.getName() + " " + student.getAge() + " " + student.getPhone() + " Группа: " + student.getGroup() +
                    " Курс: " + student.getCourse());
        } else {
            // не студент
            System.out.println("Ошибка: " + p.getName() + " " + p.getSurname() + " не является студентом и не может быть отчислен");
        }
    }

    public void demStudentDismisser(Student p) {
        System.out.println();
        System.out.println("=== Демонстрация класса StudentDismisser ===");

        System.out.println("1. Отчисление студента с полной информацией:");
        System.out.println(p.getName() + " " + p.getSurname() + " " + p.getAge() + " " + p.getPhone() + " " + p.getGroup() + " " + p.getCourse());


    }


}
