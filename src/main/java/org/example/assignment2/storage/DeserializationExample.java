package org.example.assignment2.storage;

import org.example.assignment2.student.Student;
import org.example.assignment2.userio.UserIO;

import java.io.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializationExample {

    public static List<Student> getAllStudentDetails(String fileName) {
        List<Student> studentList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            while (fileIn.available() > 0) {
                Student student = (Student) objectIn.readObject();
                studentList.add(student);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public static void deserializedDataOfStudent(String fileName) {
        List<Student> studentList = getAllStudentDetails(fileName);

        System.out.println("----------------------------------------------------------");
        System.out.println("Name \t Roll Number \t Age \t Address \t Courses");
        System.out.println("----------------------------------------------------------");
        for (Student student : studentList) {
            System.out.printf("%-10s %-10s %-10s %-10s", student.nameOfStudent,student.rollNoOfStudent, student.ageOfStudent,student.addressOfStudent);
            for (String course: student.coursesTakenByUser) {
                if (course == null)break;
                System.out.print(course+", ");
            }
            System.out.println();
        }
    }
    public static void deserializationForDeleting(String fileName,int rollNoToDelete) {
        List<Student> studentList = getAllStudentDetails(fileName);
        Student revampedStudent[] = new Student[studentList.size()-1];
        int indexToRemove=0;
        int indexForUpdatedStudent=0;
        int sizeOfStudentList = studentList.size();
        for (Student student: studentList) {
            if (student.getRollNoOfStudent() == rollNoToDelete) {
                studentList.remove(indexToRemove);
            } else {
                revampedStudent[indexForUpdatedStudent++]= new Student(student.rollNoOfStudent, student.ageOfStudent, student.nameOfStudent, student.addressOfStudent, student.coursesTakenByUser);
            }
            if (studentList.size() == sizeOfStudentList-1) {
                break;
            }
            indexToRemove++;
        }
        if (indexForUpdatedStudent == 0) {
            File file = new File("student_details.ser");
            file.delete();
            System.out.println("nothing left to save");
        }
        else {
            SerializationExample.saveStudentDetails(revampedStudent, "student_details.ser");
            deserializedDataOfStudent("student_details.ser");
        }
    }
    public static void addingNewDataInStudentList(String fileName) {
        int lengthOfRevampedList = 0;
        List<Student> studentList = getAllStudentDetails(fileName);
        Student[] studentsDetails = UserIO.getStudentDetails();
        Student revampedStudent[] = new Student[studentsDetails.length + studentList.size()];
        for (Student student: studentList) {
            revampedStudent[lengthOfRevampedList++] = new Student(student.rollNoOfStudent,student.ageOfStudent,student.nameOfStudent,student.addressOfStudent,student.coursesTakenByUser);
        }
        for (Student student: studentsDetails) {
            revampedStudent[lengthOfRevampedList++] = new Student(student.rollNoOfStudent, student.ageOfStudent, student.nameOfStudent, student.addressOfStudent, student.coursesTakenByUser);
        }
        SerializationExample.saveStudentDetails(revampedStudent,"student_details.ser");
        DeserializationExample.deserializedDataOfStudent("student_details.ser");
    }

}


