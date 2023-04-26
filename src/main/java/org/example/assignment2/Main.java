package StudentPackage;

import java.io.*;
import java.util.Comparator;
import  java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{

//        Giving Input from User
        UserIO.takeInputFromUser();

//       Saving the data in disk

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter particular thing what you want");
            System.out.println("1. Type 1 to check the sorting options");
            System.out.println("2. Type 2 to check all the details of the student");
            System.out.println("3. Type 3 to see the options for deleting a student or students");
            System.out.println("4. Else type any key to exit");
            boolean comeOut=false;
            String operationToPerform = sc.next();
            switch (operationToPerform) {
                case "1":
                    UserIO.displayWithSortOption();
                    break;
                case "2":
                    UserIO.displayDetails();
                    break;
                case "3":
                    UserIO.deleteParticularStudent();
                    break;
                default:
                    comeOut = true;
                    break;
            }
            if (comeOut == true)
                break;
        }

    }
}

