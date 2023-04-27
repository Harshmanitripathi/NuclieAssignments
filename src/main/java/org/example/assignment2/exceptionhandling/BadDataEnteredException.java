package org.example.assignment2.exceptionhandling;

public class BadDataEnteredException extends Exception{

    String errorCameFromEnteringBadData;
     public BadDataEnteredException(String errorCameFromEnteringBadData){
        this.errorCameFromEnteringBadData = errorCameFromEnteringBadData;
    }

    @Override
    public String toString() {
        return errorCameFromEnteringBadData;
    }
}
