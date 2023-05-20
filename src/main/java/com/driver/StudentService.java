package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepositary studentRepositary;
    public void addStudent(Student student){
        studentRepositary.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepositary.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String student, String teacher){
        studentRepositary.addStudentTeacherPair(student, teacher);
    }

    public Student getStudentByName(String name){
        return studentRepositary.getStudentByName(name);
    }
    public Teacher getTeacherByName(String name){
        return studentRepositary.getTeacherByName(name);
    }
    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepositary.getStudentsByTeacherName(teacher);
    }
    public List<String> getAllStudents(){
        return studentRepositary.getAllStudents();
    }
    public void deleteTeacherByName(String name){
        List<String> students = studentRepositary.getStudentsByTeacherName(name);
        studentRepositary.deleteTeacherByName(name, students);
    }
    public void deleteAllTeachers(){
        List<String> teachers = studentRepositary.getAllTeachers();
        for(String teacher : teachers){
            deleteTeacherByName(teacher);
        }
    }
}
