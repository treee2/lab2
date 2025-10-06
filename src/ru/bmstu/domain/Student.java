package ru.bmstu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ru.bmstu.service.Dismissable;

public class Student extends Person implements Dismissable {
    private String group;
    private int course;
    private List<Subject> subjects;


    public Student(String name, String surname, int age, String phone, String group, int course) {
        super(name, surname, age, phone);
        this.group = group;
        this.course = course;
        this.subjects = new ArrayList<>();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() { return course; }

    public void setCourse(int course) { this.course = course; }

    public List<Subject> getSubjects() {
        return new ArrayList<>(subjects);
    }

    public void addSubject(String name, int grade) {
        Subject subject = new Subject(name, grade);
        subjects.add(subject);
        Collections.sort(subjects); // Сортировка в обратном алфавитном порядке
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        Collections.sort(subjects);
    }

    public double getAverageGrade() {
        if (subjects.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (Subject subject : subjects) {
            sum += subject.getGrade();
        }
        return (double) sum / subjects.size();
    }

}
