package StudentPackage;
import java.util.*;
public class Validation extends Exception{


    static boolean validateUserInputForBadInput(String valueToValidate){
        boolean check=true;
            try {

                for (int i=0;i < valueToValidate.length();i++) {
                    if (!(valueToValidate.charAt(i)>='0' && valueToValidate.charAt(i)<='9'))
                        check=false;
                    if (check == false) {

                        throw new BadDataEnteredException("Number of Student Must be in Digits");

                    }

                }
            } catch (BadDataEnteredException x) {
                System.out.println(x.toString());
                check =false;
            }
            return check;
        }


    static boolean validateUserInputForNotvalidLength(String valueToValidate, String countForuser){
        boolean check=true;
        Scanner sc = new Scanner(System.in);
        try{
            if (Integer.parseInt(valueToValidate) > Integer.parseInt(countForuser)) {
                check=false;
                throw new LengthOutOfBound(valueToValidate);
            }
            if (check == false)
                return false;
        }
        catch (LengthOutOfBound x){
            check=false;
            System.out.println(x);
        }
        return check;
    }

    static boolean validateForName(String nameOfStudent,int i){
        boolean check = true;
       try{
                if (nameOfStudent.charAt(0) >= '0' && nameOfStudent.charAt(0) <= '9'){

                    throw new BadDataEnteredException("Name should not start with Digit");}
                if (nameOfStudent.charAt(0) >= 'a' && nameOfStudent.charAt(0) <= 'z'){

                    throw new BadDataEnteredException("Name should not start with Small Alphabets");}

                int checkForSpace = 0;
                for (int j = 0; j < nameOfStudent.length(); j++) {
                    if (nameOfStudent.charAt(i) == ' ') {
                        checkForSpace++;
                        if (nameOfStudent.charAt(i + 1) >= '0' && nameOfStudent.charAt(i + 1) <= '9'){
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


