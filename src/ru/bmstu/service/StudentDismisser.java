package ru.bmstu.service;

import ru.bmstu.domain.Person;
import ru.bmstu.domain.Student;

public class StudentDismisser implements Dismissable {

    @Override
    public void dismiss(Person p) {
        Person person = (Person) p;
        System.out.println("отчисленные:  " + p.getSurname() + "   "+ p.getName() +  "   "+ p.getAge() + "   " + p.getPhone());
    }
    public void demStudentDismisser(Student p) {
            System.out.println();
            System.out.println("=== Демонстрация класса StudentDismisser ===");




            System.out.println("1. Отчисление студента с полной информацией:");
            System.out.println(p.getName() + " " +  p.getSurname() + " " +  p.getAge() + " " +  p.getPhone() + " " +  p.getGroup() +  " " +  p.getCourse());



        }


}
