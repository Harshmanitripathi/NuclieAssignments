package StudentPackage;

public class ClassNotFound extends Exception{
    String errorInClass;
    ClassNotFound (String errorInClass){
        this.errorInClass = errorInClass;
    }

    @Override
    public String toString() {
        return "ClassNotFound{" +
                "errorInClass='" + errorInClass + '\'' +
                '}';
    }
}
