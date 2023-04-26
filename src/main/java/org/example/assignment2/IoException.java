package StudentPackage;

public class IoException extends Exception{
    String errorInputOutputFile;
   public IoException (String errorInputOutputFile){
        this.errorInputOutputFile = errorInputOutputFile;
    }

    public IoException(String errorInputOutputFile, Throwable cause){
       super(errorInputOutputFile, cause);
    }


    @Override
    public String toString() {
        return "IoException{" +
                "errorInputOutputFile='" + errorInputOutputFile + '\'' +
                '}';
    }
}
