package ru.job4j.oop;

public class Error {

    private boolean active;

    private int status;

    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        System.out.println();
        Error error1 = new Error(true, 404, "Not Found");
        error1.printInfo();
        System.out.println();
        Error error2 = new Error(true, 406, "Not Acceptable");
        error2.printInfo();
        System.out.println();
        Error error3 = new Error(true, 408, "Request Timeout");
        error3.printInfo();
    }
}
