package com.airtribe.repo;

import com.airtribe.entity.enrollment;

import java.util.ArrayList;
import java.util.List;

public class enrollmentRepo
{
    private List<enrollment> enrollments = new ArrayList<>();

    public void save(enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<enrollment> findAll() {
        return enrollments;
    }

    public List<enrollment> findByStudentId(int studentId) {
        List<enrollment> studentEnrollments = new ArrayList<>();
        for (enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                studentEnrollments.add(e);
            }
        }
        return studentEnrollments;
    }
}
