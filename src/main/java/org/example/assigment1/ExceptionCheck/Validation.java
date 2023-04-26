package org.example.assigment1.ExceptionCheck;


import java.util.*;
public class Validation extends Exception{


    public static boolean validateUserInputForBadInput(String valueToValidate){
        boolean check=true;
        try {

            for (int i=0;i < valueToValidate.length();i++) {
                if (!(valueToValidate.charAt(i)>='0' && valueToValidate.charAt(i)<='9'))
                    check=false;
                if (check == false) {

                    throw new BadDataEnteredException("Number of goods Must be in Digits");

                }

            }
        } catch (BadDataEnteredException x) {
            System.out.println(x.toString());
            check =false;
        }
        return check;
    }

        public static boolean validateForName(String nameOfitem){
        boolean check = true;
        try{
            if (nameOfitem.charAt(0) >= '0' && nameOfitem.charAt(0) <= '9'){

                throw new BadDataEnteredException("Name should not start with Digit");}
            if (nameOfitem.charAt(0) >= 'a' && nameOfitem.charAt(0) <= 'z'){

                throw new BadDataEnteredException("Name should not start with Small Alphabets");}

            int checkForSpace = 0;
            for (int j = 0; j < nameOfitem.length(); j++) {
                if (nameOfitem.charAt(j) == ' ') {
                    checkForSpace++;
                    if (nameOfitem.charAt(j + 1) >= '0' && nameOfitem.charAt(j + 1) <= '9'){
                        throw new BadDataEnteredException("Any part of Name should not start with Digit");}

                }
            }
            if (checkForSpace > 2) {

                throw new BadDataEnteredException("Name should not be more than 3 words");
            }

        } catch (BadDataEnteredException x) {
            System.out.println(x.toString());
            check = false;
        }
        return check;
    }


}



