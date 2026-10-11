package com.airtribe.repo;

import com.airtribe.entity.student;

import java.util.ArrayList;
import java.util.List;

public class studentRepo {

    private List<student> students = new ArrayList<>();

    public void save(student student) {
        students.add(student);
    }
    public List<student> findAll() {
        return students;
    }

    public student findById(int id) {
        for (student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }


}
