package com.airtribe.service;

import com.airtribe.entity.student;
import com.airtribe.exception.EntityNotFoundException;
import com.airtribe.repo.studentRepo;
import com.airtribe.util.IdGenerator;

import java.util.List;

public class studentService {

    private studentRepo studentRepo= new studentRepo();

    public student addStudent(String firstName, String lastName, String batch) {
        int id = IdGenerator.getStudentcounter();
        student student = new student(id, firstName, lastName, batch);
        studentRepo.save(student);
        return student;
    }
    public student addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.getStudentcounter();
        student student = new student(id, firstName, lastName, email, batch);
        studentRepo.save(student);
        return student;
    }
    public List<student> getAllStudents() {
        return studentRepo.findAll();
    }

    public student findStudentById(int id) throws EntityNotFoundException {
        student student = studentRepo.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student with ID " + id + " not found!");
        }
        return student;
    }

    public void deactivateStudent(int id) throws EntityNotFoundException {
        student student = findStudentById(id);
        student.setActive(false);
    }
}
