package imc;

import java.util.ArrayList;
import java.util.HashSet;



public class IMC_Error {

    public enum error_type {
        WARNING,
        ERROR
    }

    private HashSet<Error> errors;

    public IMC_Error() {
        this.errors = new HashSet<Error>();
    }

    public IMC_Error(IMC_Error e) {
        this.errors = e.getErrors();
    }

    public IMC_Error(HashSet<Error> errors) {
        HashSet<Error> tmp = new HashSet<Error>();

        for (Error e : errors) {
            tmp.add(e.clone());
        }

        this.errors = tmp;

    }

    public void insertError(error_type t,String message) {
        errors.add(new Error(t,message));
    }

    public HashSet<Error> getErrors() {
        HashSet<Error> tmp = new HashSet<Error>();

        for (Error e : errors)
            tmp.add(e);

        return tmp;
    }

    public ArrayList<String> getWarningList() {

        ArrayList<String> tmp = new ArrayList<String>();

        for (Error e : errors) {
            if(e.getType() == error_type.WARNING)
                tmp.add(e.getMessage());
        }

        return tmp;
    }

    public ArrayList<String> getErrorList() {

        ArrayList<String> tmp = new ArrayList<String>();

        for (Error e : errors) {
            if(e.getType() == error_type.ERROR)
                tmp.add(e.getMessage());
        }

        return tmp;
    }


    @Override
    public IMC_Error clone() {
        IMC_Error tmp = new IMC_Error(this);
        return tmp;
    }





    private class Error {

        private error_type type;
        private String message;


        public Error(error_type type, String message) {
            this.type = type;
            this.message = message;
        }

        public Error(Error e) {
            this.type = e.getType();
            this.message = e.getMessage();
        }


        public error_type getType() {
            return type;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setType(error_type type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Error error = (Error) o;

            if (!message.equals(error.message)) return false;
            if (type != error.type) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = type.hashCode();
            result = 31 * result + message.hashCode();
            return result;
        }

        @Override
        public Error clone() {
            Error e = new Error(this);
            return e;
        }
    }


}
