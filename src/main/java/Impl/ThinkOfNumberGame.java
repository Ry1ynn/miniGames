package Impl;

import domain.Game;
import domain.User;

import java.util.Random;
import java.util.Scanner;

public class ThinkOfNumberGame implements Game {

    private static final int COUNT_OF_TRIES = 5;
    private int currentMaxNumber = 100;
    private int currentMinNumber = 0;
    private final User user;

    public ThinkOfNumberGame(User user) { this.user = user; }

    @Override
    public void play() {
        long bet = makeBet();
        checkUserReady();
        int currentTry = 0;
        int numberToGuess = new Random().nextInt(101);
        if (guessUsersNumber(numberToGuess, currentTry)) {
            user.reduceMoney(bet);
        } else {
            user.increaseMoney(bet);
        }
    }

    public long makeBet() {
        System.out.println("Сделайте ставку");
        long bet = new Scanner(System.in).nextLong();
        if (bet> user.getMoney()) {
            System.out.println("Сумма ставки превышает сумму на балансе!");
            while (bet> user.getMoney()) {
                bet = new Scanner(System.in).nextLong();
            }
        } else {
            System.out.println("Ставка сделана.");
        }
        return bet;
    }

    private String checkUserReady() {
        System.out.println("Загадайте число от 0 до 100 и вбейте 'Загадал': ");
        String userCheck = new Scanner(System.in).nextLine();
        if (userCheck.equalsIgnoreCase("Загадал")) {
            return userCheck;
        } else {
                System.out.println("Вы ввели " + userCheck + "\nЕсли вы загадали число, введите 'Загадал'");
                checkUserReady();
            }
        return null;
    }

    private boolean guessUsersNumber(int numberToGuess, int currentTry) {
        currentTry++;
        if (checkCountOfTries(currentTry)) {
            System.out.println("Выигрыш! Программа исчерпала количество попыток");
            return false;
        }
        System.out.println("Ваше число - " + numberToGuess + "?\nВведите: \n* Да\n* Больше\n* Меньше");
        String userAnswer = new Scanner(System.in).nextLine();
        if (userAnswer.equalsIgnoreCase("Да")) {
            System.out.println("Проигрыш! Система угадала число");
            return true;
        } else if (userAnswer.equalsIgnoreCase("Больше")) {
            currentMinNumber = numberToGuess;
            int newNumberToGuess = (currentMaxNumber+numberToGuess) / 2;
            guessUsersNumber(newNumberToGuess, currentTry);
        } else if (userAnswer.equalsIgnoreCase("Меньше")) {
            currentMaxNumber = numberToGuess;
            int newNumberToGuess = (numberToGuess+currentMinNumber)/2;
            guessUsersNumber(newNumberToGuess, currentTry);
        } else {
            System.out.println("Некорректный ввод");
            currentTry--;
            guessUsersNumber(numberToGuess, currentTry);
        }
        return false;
    }

    private boolean checkCountOfTries(int currentTry) { return currentTry-1 == COUNT_OF_TRIES; }
}
