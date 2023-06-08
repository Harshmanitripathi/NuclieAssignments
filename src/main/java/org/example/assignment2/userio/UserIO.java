package org.example.assignment2.userio;

import org.example.assignment2.deleting.DeletingStudents;
import org.example.assignment2.exceptionhandling.BadDataEnteredException;
import org.example.assignment2.sort.SortByRollNo;
import org.example.assignment2.sort.SortByAddress;
import org.example.assignment2.sort.SortByAge;
import org.example.assignment2.sort.SortByName;
import org.example.assignment2.storage.SerializationExample;
import org.example.assignment2.storage.DeserializationExample;
import org.example.assignment2.student.Student;
import org.example.assignment2.exceptionhandling.Validation;

import java.io.IOException;
import java.net.BindException;
import java.util.*;
import java.io.*;
import java.util.Comparator;
public class UserIO {
   static Student[] student;
   static Student[] modifiedStudentDetail;
   public static boolean userBenefits() throws IOException {
       Scanner sc = new Scanner(System.in);
       boolean checkForBenefit = false;
       while (!checkForBenefit) {
           System.out.println("1. Add User details.");
           System.out.println("2. Display User details.");
           System.out.println("3. Delete User details.");
           System.out.println("4. Save User details.");
           System.out.println("5. Exit.");
           String userInputForBenefits = sc.next();
           switch (userInputForBenefits) {
               case "1":
                   takeInputFromUser();
                   break;
               case "2":
                   DeserializationExample.deserializedDataOfStudent("student_details.ser");
                   break;
               case "3":
                   deleteParticularStudent();
                   break;
               case "4":
                   if (student != null) {
                       SerializationExample.saveStudentDetails(student, "student_details.ser");
                   } else {
                       System.out.println("Press 1 to enter data, there is nothing to save");
                   }
                   break;
               case "5":
                   checkForBenefit = true;
                   break;
               default:
                   System.out.println("Enter 1-5 ");
                   break;
           }
       }
       return checkForBenefit;
   }
    public static void takeInputFromUser() throws IOException {
//        Taking Input from user Starts over here
        Scanner sc = new Scanner(System.in);
        String noOfStudents1="";
        System.out.println("Enter the no. of Student to enter the details");

//        Validation for Number Of Student
        while(true) {
            System.out.print("No. of Student: ");
            noOfStudents1 = sc.next();
            if(Validation.validateUserInputForBadInput(noOfStudents1))
                break;
        }

        int noOfStudents = Integer.parseInt(noOfStudents1);
        String rollNo1 = "", ageOfStudent1 = "";
        String addressOfStudent = "", nameOfStudent = "";
        String[] setOfCourses = new String[1000];

         student = new Student[noOfStudents];

        for (int i = 0; i < noOfStudents; i++) {
            int g=i+1;
            System.out.println("Enter the details of Student: " + g );

//            Validation for Roll No

            int rollNoIsright=0;
            while (true){
                System.out.print("Enter roll no of student:");
                rollNo1 = sc.next();
                if(Validation.validateUserInputForBadInput(rollNo1)){
                    rollNoIsright=1;
                    break;}
            }

            if (rollNoIsright==0)
            while(true){
                System.out.println("Enter the roll no. again");
                rollNo1 = sc.next();
                if (Validation.validateUserInputForNotvalidLength(rollNo1,noOfStudents1))
                    break;
            }

            int rollNo = Integer.parseInt(rollNo1);


//            Validation for Age
            while (true){
                System.out.print("Enter age of student:");
                ageOfStudent1 = sc.next();
                if(Validation.validateUserInputForBadInput(ageOfStudent1))
                    break;
            }



            int ageOfStudent = Integer.parseInt(ageOfStudent1);

//            Validation for Name
            while (true) {
                System.out.print("Enter the name of student: ");
                nameOfStudent = sc.next();
                if (Validation.validateForName(nameOfStudent, i))
                    break;
            }

//            Validation for Address
            while (true){
                System.out.println("Enter address of student");
                addressOfStudent = sc.next();
                if (Validation.validateForName(addressOfStudent,i))
                    break;
            }


            System.out.println("enter the courses name whom you want to take , enter (Y) when its over");


                int k=0;
            while (true) {

                try {
                    while (true) {
                        String inputFromUserAboutTheCourses = sc.next();
                        if (((inputFromUserAboutTheCourses).toLowerCase()).equals("y") == true)
                            break;
                        if (Arrays.asList(setOfCourses).contains(inputFromUserAboutTheCourses.toUpperCase()) == true)
                            System.out.println("This course you entered previously");
                        else
                            setOfCourses[k++] = inputFromUserAboutTheCourses.toUpperCase();

                        String d = inputFromUserAboutTheCourses.toUpperCase();

                        if (!(d.equals("A") || d.equals("B") || d.equals("C") || d.equals("D") || d.equals("E") || d.equals("F")))
                            throw new BadDataEnteredException("Courses available are A,B,C,D,E,F");
                        if (d.equals("Y"))
                            if (!(k >= 4 && k <= 6))
                                throw new BadDataEnteredException("Courses entered should be atleast 4 and less than 6");
                    }
                       }
                      catch (BadDataEnteredException x){
                           System.out.println(x.toString());
                           continue;
                       }

                break;
            }

            student[i]= new Student(rollNo, ageOfStudent, nameOfStudent, addressOfStudent, setOfCourses);
            setOfCourses = new String[setOfCourses.length];
        }
//       Taking Input Ends Over here

//        Default Sorting based on Age
        Arrays.sort(student, new SortByAge());


//        Using singleton class to store data
//        serialize the data in singleton class
//        byte[] serialized = FileInputOutputInstance.getInstance().serializeData();
//        FileInputOutputInstance.getInstance().setDataininstringform(student);

//        de-serialize the data in singleton class
//        try {
//            Object[] serializedData = FileInputOutputInstance.getInstance().getDataininstringform();
//            FileInputOutputInstance.getInstance().deserialize(serialized);
//            System.out.println("----------------------------------------------------------");
//            System.out.println("Name \t Roll Number \t Age \t Address \t Courses");
//            System.out.println("----------------------------------------------------------");
//
//            for (int i = 0; i < serializedData.length; i++) {
//                if (serializedData[i] == null)break;
//                System.out.println(serializedData[i].toString());
//            }
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        SerializationExample.saveStudentDetails(student,"student_details.ser");
//        DeserializationExample.deserializedDataOfStudent("student_details.ser");
        DeserializationExample.addingNewDataInStudentList("student_details.ser");
        displayWithSortOption();



//        FileInputOutput.saveStudentDetailsInFile(student);
    }
    public static Student[] getStudentDetails() {
       return student;
    }
   public static void displayWithSortOption(){
        System.out.println("Enter the way you want to sort as you like ");
        System.out.println("1. Age");
        System.out.println("2. Name");
        System.out.println("3. Roll no");
        System.out.println("4. Address");
        Scanner sc = new Scanner(System.in);
        int sortBy = sc.nextInt();
        switch (sortBy) {
            case 1:
                Arrays.sort(student, new SortByAge());
                SerializationExample.saveStudentDetails(student,"student_details.ser");
                DeserializationExample.deserializedDataOfStudent("student_details.ser");
                break;
            case 2:
                Arrays.sort(student, new SortByName());
                SerializationExample.saveStudentDetails(student,"student_details.ser");
                DeserializationExample.deserializedDataOfStudent("student_details.ser");
                break;
            case 3:
                Arrays.sort(student, new SortByRollNo());
                SerializationExample.saveStudentDetails(student,"student_details.ser");
                DeserializationExample.deserializedDataOfStudent("student_details.ser");
                break;
            case 4:
                Arrays.sort(student, new SortByAddress());
                SerializationExample.saveStudentDetails(student,"student_details.ser");
                DeserializationExample.deserializedDataOfStudent("student_details.ser");
                break;
        }
    }

    public static void displayDetails(){
        System.out.println("----------------------------------------------------------");
        System.out.println("Name \t Roll Number \t Age \t Address \t Courses");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < student.length; i++) {
            if (student[i] == null)break;
            student[i].display();
        }
    }

    public static void deleteParticularStudent(){
        Scanner sc = new Scanner(System.in);
        String finishDeleting = "";

            System.out.println("Enter the rollno you want to delete");
            int rollNoToBeDeleted = sc.nextInt();
            boolean checkForRollNo = false;
            DeserializationExample.deserializationForDeleting("student_details.ser",rollNoToBeDeleted);
//            DeletingStudents.studentDeleted(student,rollNoToBeDeleted, checkForRollNo);
//            System.out.println("If you are done deleting type y else type no");
//            finishDeleting = sc.next();

    }

}







