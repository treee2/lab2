package ru.bmstu.domain;

import ru.bmstu.service.Dismissable;

public class Student extends Person implements Dismissable {
    private String group;
    private int course;


    public Student(String name, String surname, int age, String phone, String group, int course) {
        super(name, surname, age, phone);
        this.group = group;
        this.course = course;

    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() { return course; }

    public void setCourse(int course) { this.course = course; }

}
