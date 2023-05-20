package com.driver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
public class Teacher {

    private String name;

    private int numberOfStudents;

    private int age;

    public Teacher() {

    }
}