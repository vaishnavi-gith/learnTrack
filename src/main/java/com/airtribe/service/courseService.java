package com.airtribe.service;

import com.airtribe.entity.course;
import com.airtribe.exception.EntityNotFoundException;
import com.airtribe.repo.courseRepo;
import com.airtribe.util.IdGenerator;

import java.util.List;

public class courseService {
    private courseRepo courseRepository = new courseRepo();

    public course addCourse(String courseName, String description, int durationInWeeks) {
        int id = IdGenerator.getCoursecounter();
        course course = new course(id, courseName, description, durationInWeeks);
        courseRepository.save(course);
        return course;
    }

    public List<course> getAllCourses() {
        return courseRepository.findAll();
    }

    public course findCourseById(int id) throws EntityNotFoundException {
        course course = courseRepository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course with ID " + id + " not found!");
        }
        return course;
    }

    public void toggleCourseStatus(int id) throws EntityNotFoundException {
        course course = findCourseById(id);
        course.setActive(!course.isActive());
    }
}
