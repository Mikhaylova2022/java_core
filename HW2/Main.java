package lesson2.HW2;

import lesson2.HW2.MyArrayDataException;
import lesson2.HW2.MyArraySizeException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // input array
        Scanner scan = new Scanner(System.in);
        System.out.print("Пожалуйста, введите размер массива: ");
        int arraySize = scan.nextInt();
        String[][] strArray = new String[arraySize][arraySize];
        for(int i = 0; i < arraySize; i++) {
            for(int j = 0; j < arraySize; j++) {
                System.out.print("Введите, пожалуйста, для суммирования значение ячейки массива  [" + i + "][" + j + "]: ");
                strArray[i][j] = scan.next();
            }
        }

        ArrayChecker checker = new ArrayChecker(strArray);
        try {
            checker.checkArraySize();
            System.out.println(" Отлично, у нас всё получилось! Сумма элементов массива = " + checker.sumArrayElements());
        }
        catch(MyArraySizeException|MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Ой, у нас проблемка! Не удалось вычислить сумму массива :( ");
        }
    }
}
