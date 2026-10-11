package com.airtribe.repo;

import com.airtribe.entity.course;
import com.airtribe.entity.student;

import java.util.ArrayList;
import java.util.List;

public class courseRepo {

    private List<course> courses = new ArrayList<>();

    public void save(course course) {
        courses.add(course);
    }
    public List<course> findAll() {
        return courses;
    }

    public course findById(int id) {
        for (course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
