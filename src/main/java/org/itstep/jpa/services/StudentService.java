package org.itstep.jpa.services;

import org.itstep.jpa.entities.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(final Student student);

    Student updateStudent(final Student student);

    List<Student> getAllStudent();

    Student getStudent(final Long id);

    void deleteStudent(final Long id);
}
