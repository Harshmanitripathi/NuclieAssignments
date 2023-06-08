package org.example.assignment2.storage;

import org.example.assignment2.student.Student;

import java.io.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {
    public static void saveStudentDetails(Student student[], String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            for (Student student1: student) {
                objectOut.writeObject(student1);
            }
            System.out.println("Student details saved to " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void setStudentDetailsInSerializedDisk(Student studentOriginal) {
//        Student student = new Student(studentOriginal.rollNoOfStudent, studentOriginal.ageOfStudent,studentOriginal.nameOfStudent,studentOriginal.addressOfStudent,studentOriginal.coursesTakenByUser);
//
//        String fileName = "student_details.ser";
//        saveStudentDetails(student, fileName);
//    }
}

