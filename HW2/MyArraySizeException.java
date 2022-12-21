package lesson2.HW2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(String errorMessage) {
        super(errorMessage);
    }
}