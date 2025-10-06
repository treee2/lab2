package ru.bmstu.domain;

import ru.bmstu.exception.InvalidPhoneNumberException;

public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private String phone;

    public Person(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public Person(String firstName, String secondName, int age, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.phone = phone;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) throws InvalidPhoneNumberException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new InvalidPhoneNumberException("Номер телефона не может быть пустым");
        }

        // Удаляем все пробелы и дефисы для проверки
        String cleanPhone = phone.replaceAll("[\\s-]", "");

        // Проверка, что номер содержит только цифры и знак +
        if (!cleanPhone.matches("^\\+?[0-9]+$")) {
            throw new InvalidPhoneNumberException("Номер телефона может содержать только цифры и знак +");
        }

        // Проверка номера (от 10 до 15 цифр)-длина
        String digitsOnly = cleanPhone.replace("+", "");
        if (digitsOnly.length() < 10 || digitsOnly.length() > 15) {
            throw new InvalidPhoneNumberException("Номер телефона должен содержать от 10 до 15 цифр");
        }

        this.phone = phone;
    }
}
