package lesson4.HW4;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class PhoneDirectory {
    TreeMap<String, HashSet<String>> directoryList = new TreeMap<>();
    /*Хэш сет для избежания дублирования номеров*/

    public PhoneDirectory() {
        super();
    }

    public PhoneDirectory(TreeMap<String, HashSet<String>> directoryList) {
        this.directoryList = directoryList;
    }

    /* Добавляем новую запись*/
    public void add(String surname, String phoneNumber) {
        HashSet<String> phones = new HashSet<>();
        if (directoryList.containsKey(surname)) {
            phones = directoryList.get(surname);
        }
        phones.add(phoneNumber.replaceAll(" ", ""));
        directoryList.put(surname, phones);
    }

    /* Получаем телефоны*/
    public HashSet<String> get(String surname) {
        return directoryList.get(surname);
    }

    /*вывести весь справочник*/
    public void printPhoneDirectory() {
        System.out.println("Печать всего телефонного справочника");
        for(Map.Entry<String, HashSet<String>> entry: directoryList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            System.out.println(entry.getValue());
        }
        System.out.println("--------------------------------------");
    }

    /* Выборка телефона по фамилии*/
    public void printPhonesBySurname(String surname) {
        if (directoryList.containsKey(surname)) {
            System.out.println("Номер телефона для " + surname + "':" + get(surname)) ;
        } else {
            System.out.println(" Увы, такого контакта '" + surname + "' не существует");
        }
    }
}
