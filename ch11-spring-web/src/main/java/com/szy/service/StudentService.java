package com.szy.service;

import com.szy.domain.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);
    List<Student> queryStudents();
}
