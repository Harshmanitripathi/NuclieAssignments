package StudentPackage;

import java.util.Queue;
import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable{
    public int rollNoOfStudent, ageOfStudent;
    public String nameOfStudent, addressOfStudent;
    //    boolean courseA, courseB, courseC, courseD, courseE, courseF;
    public String coursesTakenByUser[] = new String[100000];

    public Student(int rollNoOfStudent, int ageOfStudent, String nameOfStudent, String addressOfStudent, String[] coursesTakenByUser) {
        this.rollNoOfStudent = rollNoOfStudent;
        this.ageOfStudent = ageOfStudent;
        this.nameOfStudent = nameOfStudent;
        this.addressOfStudent = addressOfStudent;
        this.coursesTakenByUser = coursesTakenByUser;
    }




    public int getRollNoOfStudent() {
        return rollNoOfStudent;
    }

    public void setRollNoOfStudent(int rollNoOfStudent) {
        this.rollNoOfStudent = rollNoOfStudent;
    }

    public int getAgeOfStudent() {
        return ageOfStudent;
    }

    public void setAgeOfStudent(int ageOfStudent) {
        this.ageOfStudent = ageOfStudent;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public String getAddressOfStudent() {
        return addressOfStudent;
    }

    public void setAddressOfStudent(String addressOfStudent) {
        this.addressOfStudent = addressOfStudent;
    }

    public String[] getCoursesTakenByUser() {
        return coursesTakenByUser;
    }

    public void setCoursesTakenByUser(String[] coursesTakenByUser) {
        this.coursesTakenByUser = coursesTakenByUser;
    }

    public void display(){

        System.out.print(this.getNameOfStudent()+"\t"+this.getRollNoOfStudent()+"\t"+this.getAgeOfStudent()+"\t"+this.getAddressOfStudent()+"\t");
        for (String course: this.getCoursesTakenByUser()) {
            if (course == null)break;
            System.out.print(course+", ");
        }
        System.out.println();
    }

//    public  void studentDeleted( int rollNoToBeDeleted, boolean checkForRollNo) {
//
//        while (checkForRollNo == false){
//
//
//
//                if (this.getRollNoOfStudent() == rollNoToBeDeleted){
//                    checkForRollNo = true;
//
//                    for (int j=i;j<student.length-1;j++){
//
//                        student[j] = student[j+1];
//                    }
//                    student[student.length-1] = null;
//                    break;
//                }
//
//            if (checkForRollNo == false)
//            {
//
//                System.out.println("Please enter the valid rollNo");
//                Scanner sc = new Scanner(System.in);
//                rollNoToBeDeleted = sc.nextInt();
//            }
//        }

//    }
}
