package Impl;

import domain.Registrator;
import domain.User;

import java.util.Scanner;

public class RegistratorImpl implements Registrator {
    @Override
    public User registerUser() {
        System.out.println("Привет! Представься: ");
        String name = new Scanner(System.in).nextLine();
        if (name.isEmpty()) {
            System.out.println("Поле не заполнено");
            registerUser();
        }

        char[] nameChar = name.toCharArray();

        for (int i=0; i<nameChar.length; i++) {
                if (nameChar[i] == ' ') {
                    System.out.println("Имя должно состоять только из букв и одного слова");
                    registerUser();
                }
        }
        if (name.contains("0") ||
                name.contains("1") ||
                name.contains("2") ||
                name.contains("3") ||
                name.contains("4") ||
                name.contains("5") ||
                name.contains("6") ||
                name.contains("7") ||
                name.contains("8") ||
                name.contains("9")) {
            System.out.println("Имя должно состоять только из букв и одного слова");
            registerUser();
        }
        return new UserImpl(name.substring(0,1).toUpperCase()+name.substring(1,name.length()));
    }
}
