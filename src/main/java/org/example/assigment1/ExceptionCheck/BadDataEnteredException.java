package org.example.assigment1.ExceptionCheck;
public class BadDataEnteredException extends Exception {
    String errorCameFromEnteringBadData;
    BadDataEnteredException(String errorCameFromEnteringBadData) {
        this.errorCameFromEnteringBadData = errorCameFromEnteringBadData;
    }
    @Override
    public String toString() {
        return errorCameFromEnteringBadData;
    }
}
