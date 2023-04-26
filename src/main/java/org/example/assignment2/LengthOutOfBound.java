package StudentPackage;

public class LengthOutOfBound extends Exception{
    String lengthEnteredByUser;
    LengthOutOfBound (String lengthEnteredByUser){
        this.lengthEnteredByUser = lengthEnteredByUser;
    }

    @Override
    public String toString() {
        return "LengthOutOfBound{" +
                "lengthEnteredByUser='" + lengthEnteredByUser + '\'' +
                "} is beyond the range we accept";
    }
}
