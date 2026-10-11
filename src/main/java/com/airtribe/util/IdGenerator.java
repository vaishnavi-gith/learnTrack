package com.airtribe.util;

public class IdGenerator {
    private static int studentcounter = 100;
    private static int coursecounter = 200;
    private static int enrollidcounter=1;

    public static int getStudentcounter()
    {
        studentcounter++;
        return studentcounter;
    }
    public static int getCoursecounter()
    {
        coursecounter++;
        return coursecounter;
    }
    public static int getEnrollidcounter()
    {
        enrollidcounter++;
        return enrollidcounter;
    }
}
