package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Нерезько Наталия Александровна");
        student.setGroup("АР-51");
        student.setAdmission(new Date());

        System.out.println("Студент(ка): " + student.getFio() + " из группы " + student.getGroup() + " поступил(а) в университет " + student.getAdmission());
    }
}
