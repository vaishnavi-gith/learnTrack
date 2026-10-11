package com.airtribe.service;

import com.airtribe.entity.course;
import com.airtribe.entity.enrollment;
import com.airtribe.exception.EntityNotFoundException;
import com.airtribe.repo.courseRepo;
import com.airtribe.repo.enrollmentRepo;
import com.airtribe.util.IdGenerator;

import java.util.List;

public class enrollmentService
{

    private enrollmentRepo enrollmentRepository = new enrollmentRepo();
    private studentService studentService;
    private courseService courseService;

    public enrollmentService(studentService studentService, courseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public enrollment enrollStudent(int studentId, int courseId) throws EntityNotFoundException {
        // Validate that both student and course exist first!
        studentService.findStudentById(studentId);
        courseService.findCourseById(courseId);

        int id = IdGenerator.getEnrollidcounter();
        enrollment enrollment = new enrollment(id, studentId, courseId);
        enrollmentRepository.save(enrollment);
        return enrollment;
    }

    public List<enrollment> getEnrollmentsForStudent(int studentId) throws EntityNotFoundException {
        studentService.findStudentById(studentId); // Verify student exists
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public void updateEnrollmentStatus(int enrollmentId, String status) throws EntityNotFoundException {
        for (enrollment e : enrollmentRepository.findAll()) {
            if (e.getId() == enrollmentId) {
                e.setStatus(status);
                return;
            }
        }
        throw new EntityNotFoundException("Enrollment with ID " + enrollmentId + " not found!");
    }
}
