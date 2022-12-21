package lesson3.HW3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(" Задание №1 ");
        ArrayMethodsGeneric<Integer> gen1 = new ArrayMethodsGeneric<>(3, 0, 1, 7, 9);
        gen1.printArray();
        gen1.swapArrayElements(1, 4);
        gen1.printArray();

        ArrayMethodsGeneric<String> gen2 = new ArrayMethodsGeneric<>("число 1", "число2", "число3", "число4", "число5");
        gen2.printArray();
        gen2.swapArrayElements(1, 5);
        gen2.printArray();

        System.out.println(" _________________________________________________");
        System.out.println(" Задание №2");
        Box<Apple> appleBox = new Box< >(new ArrayList<>(Arrays.asList(new Apple(), new Apple(), new Apple(), new Apple())));
        Box<Orange> orangeBox = new Box<>(new ArrayList<>(Arrays.asList(new Orange(), new Orange(), new Orange())));
        System.out.println("Вес коробки с яблочками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинками: " + orangeBox.getWeight());
        System.out.println("Вес коробок с апельсинками и яблочками одинаковый?: " + orangeBox.compare(appleBox));

        orangeBox.addFruit(new Orange());
        System.out.println("Добавили в коробку одну апельсинку, вес стал: " + orangeBox.getWeight());

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        System.out.println("Добавим в коробку пару яблочек, вес получился: " + appleBox.getWeight());
        System.out.println(" После добавки фруктов вес коробок с апельсинками и яблочками  стал одинаковый?: " + orangeBox.compare(appleBox));

        Box<Orange> anotherOrangeBox = new Box<>(new ArrayList<>(Arrays.asList(new Orange())));
        System.out.println("Вес второй коробки с апельсинками: " + anotherOrangeBox.getWeight());
        orangeBox.pourAllFruits(anotherOrangeBox);
        System.out.println("Вес коробки (пустая):" + orangeBox.getWeight());
        System.out.println("Вес второй  коробки с апельсинками после заполнения : " + anotherOrangeBox.getWeight());
    }
}