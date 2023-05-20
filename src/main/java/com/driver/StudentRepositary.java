package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class StudentRepositary {
    HashMap<String, Student> studentMap;
    HashMap<String, Teacher> teacherMap;
    HashMap<String, List<String>> teacherStudentList;

    public void addStudent(Student student){
        studentMap.put(student.getName(), student);
    }
    public void addTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }
    public void addStudentTeacherPair(String student, String teacher){
        List<String> newlist = new ArrayList<>();
        if(teacherStudentList.containsKey(teacher)){
            newlist = teacherStudentList.get(teacher);
        }
        newlist.add(student);
        teacherStudentList.put(teacher, newlist);
    }
    public Student getStudentByName(String name){
        Student student = null;
        if(studentMap.containsKey(name)){
            student = studentMap.get(name);
        }
        return student;
    }
    public Teacher getTeacherByName(String name){
        Teacher teacher = null;
        if(teacherMap.containsKey(name)){
            teacher = teacherMap.get(name);
        }
        return teacher;
    }
    public List<String> getStudentsByTeacherName(String teacher){
        List<String> list = new ArrayList<>();
        if(teacherStudentList.containsKey(teacher)){
            list = teacherStudentList.get(teacher);
        }
        return list;
    }
    public List<String> getAllStudents(){
        return new ArrayList<>(studentMap.keySet());
    }
    public List<String> getAllTeachers(){
        return new ArrayList<>(teacherMap.keySet());
    }
    public void deleteTeacherByName(String name, List<String> students){
        teacherStudentList.remove(name);
        teacherMap.remove(name);
        for(String student : students){
            studentMap.remove(student);
        }
    }
}
