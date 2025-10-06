package ru.bmstu.domain;

public class Subject implements Comparable<Subject> {
    private String name;
    private int grade;

    public Subject(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Subject other) {
        // Сортировка в обратном порядке
        return other.name.compareTo(this.name);
    }

    @Override
    public String toString() {
        return name + ": " + grade;
    }
}
