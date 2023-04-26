package StudentPackage;

import java.util.*;

public class DeletingStudents {


    public static void studentDeleted(Student[] student, int rollNoToBeDeleted, boolean checkForRollNo) {

        while (checkForRollNo == false){

            for(int i=0;i<student.length;i++){
                if(student[i] == null)break;
                if (student[i].getRollNoOfStudent() == rollNoToBeDeleted){
                    checkForRollNo = true;

                    for (int j=i;j<student.length-1;j++){

                        student[j] = student[j+1];
                    }
                    student[student.length-1] = null;
                    break;
                }
            }
            if (checkForRollNo == false)
            {

                System.out.println("Please enter the valid rollNo");
                Scanner sc = new Scanner(System.in);
                rollNoToBeDeleted = sc.nextInt();
            }
        }

    }
}
