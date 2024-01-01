package com.driver;

import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        Student s = studentRepository.studentHashMap.get(student);
        Teacher t = studentRepository.teacherHashMap.get(teacher);
        studentRepository.addStudentTeacherPair(s,t);
    }

    public Student getStudentByName(String studentName){
        return studentRepository.getStudentByName(studentName);
    }

    public Teacher getTeacherByName(String teacherName){
        return studentRepository.getTeacherByName(teacherName);
    }

    public List<String> getStudentsByTeacherName(String teacherName){
        return studentRepository.getStudentsByTeacherName(teacherName);
    }

    public List<String> getAllStudents(){
        List<String> allStudents = new ArrayList<>();
        for(String name : studentRepository.studentHashMap.keySet()){
            allStudents.add(name);
        }
        return allStudents;
    }

    public void deleteTeacherAndItsStudents(String teacherName){
        List<String> allStudentsOfTeacher = studentRepository.studentTeacherPair.get(teacherName);
        // deleting all the students that come under teachers
        for(String studentName : allStudentsOfTeacher){
            studentRepository.deleteStudent(studentName);
        }

        //delete teacher
        studentRepository.deleteTeacher(teacherName);
    }

    public void deleteAll(){

        for(String teacher : studentRepository.teacherHashMap.keySet()){
            studentRepository.deleteTeacher(teacher);
        }
    }

}
