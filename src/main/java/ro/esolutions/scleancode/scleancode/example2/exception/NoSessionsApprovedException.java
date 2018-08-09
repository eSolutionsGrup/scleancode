package ro.esolutions.scleancode.scleancode.example2.exception;

import java.io.Serializable;

public class NoSessionsApprovedException extends Exception{
    public NoSessionsApprovedException(String message) {

        super(message);
    }
}