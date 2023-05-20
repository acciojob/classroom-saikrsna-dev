package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class StudentRepositary {
    HashMap<String, Student> studentMap;
    HashMap<String, Teacher> teacherMap;
    HashMap<String, List<String>> teacherStudentList;

    public StudentRepositary(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentList = new HashMap<String, List<String>>();
    }
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
            return studentMap.get(name);
    }
    public Teacher getTeacherByName(String name){
        return teacherMap.get(name);
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
    }
    public void removeStudent(String name){
        studentMap.remove(name);
    }
}
