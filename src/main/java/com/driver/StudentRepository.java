package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.HashMap;

@Repository
public class StudentRepository {

    // the key value is the name of the teacher and the arraylist will contains the students
    HashMap<String,List<String>>  studentTeacherPair = new HashMap<>();

    HashMap<String,Student> studentHashMap = new HashMap<>();

    HashMap<String,Teacher> teacherHashMap = new HashMap<>();


    public void addStudent(Student student){
        studentHashMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(),teacher);
    }

    // this adds a pair of a teacher and a student in hashmap, where teacher's name is a primary key
    public void addStudentTeacherPair(Student student, Teacher teacher){
        List<String> newList = studentTeacherPair.getOrDefault(teacher.getName(), new ArrayList<>());
        newList.add(student.getName());
        studentTeacherPair.put(teacher.getName(), newList);
    }

    public Student getStudentByName(String studentName){
        return studentHashMap.get(studentName);
    }

    public Teacher getTeacherByName(String teacherName){
        return teacherHashMap.get(teacherName);
    }

    public List<String> getStudentsByTeacherName(String teacherName){
        return studentTeacherPair.get(teacherName);
    }

    public void deleteStudent(String studentName){
        studentHashMap.remove(studentName);
    }

    public void deleteTeacher(String teacherName){
        teacherHashMap.remove(teacherName);
        studentTeacherPair.remove(teacherName);
    }




}

