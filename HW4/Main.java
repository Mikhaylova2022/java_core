package lesson4.HW4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        System.out.println(" Задание №1 ");

        /*Запускаем массив*/
        String[] strArray = {"один", "двадцать", "три", "два", "три", "четыре", "пять", "пять", "два", "одиннадцать", "ноль", "пять", "одиннадцать", "пять"};

        /* Выводим количество дубликатов/уникальных */
        printNumberDuplicateStrings(strArray);
        printUniqueStrings(strArray);
        System.out.println("-------------------------------------");
        System.out.println(" Задание №2 ");
        PhoneDirectory directory = new PhoneDirectory();
        /* создаем контакты*/
        directory.add("Абрамова","+79781813258");
        directory.add("Борисов","+78912113100");
        directory.add("Борисов","+78912113102");
        directory.add("Вичков","+79783211241");
        directory.add("Градова","+79783211243");

        /*создаем дубликат*/
        directory.add("Вичков","+79783211241");
       /* запрос по фамилии*/
        directory.printPhonesBySurname("Градова");
        directory.printPhonesBySurname("Борисов");

        /* вывод всего справочника*/
        directory.printPhoneDirectory();
        /* вводим несуществующий контакт*/
        directory.printPhonesBySurname("Обрамова");
    }


    public static void printUniqueStrings(String[] strArray) {
        TreeSet<String> strHashSet = new TreeSet<>(Arrays.asList(strArray));
        System.out.println(strHashSet);
    }


    public static void printNumberDuplicateStrings(String[] strArray) {
        ArrayList<String> arrayStrList = new ArrayList<>(Arrays.asList(strArray));
        Collections.sort(arrayStrList);
        System.out.println(" Определяем дубликаты для массива : " + arrayStrList + ":");
        String checkingWord = "";
        for (String strElement: arrayStrList) {
            if (!checkingWord.equals(strElement)) {
                checkingWord = strElement;
                System.out.println(strElement + " всречается " + Collections.frequency(arrayStrList, strElement) + " раз");
            }
        }
    }
}
