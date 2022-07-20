package Impl;

import domain.Game;
import domain.User;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame implements Game {

    private static final int COUNT_OF_TRIES = 5;

    private final User user;

    public GuessNumberGame(User user) { this.user = user; }

    @Override
    public void play() {
        long bet = makeBet();
        int currentTry = 0;
        int numberToGuess = new Random().nextInt(101);
        System.out.println("Загадано число, требуется угадать за " + COUNT_OF_TRIES + " попыток.");
        if (guessUsersNumber(numberToGuess, currentTry)) {
            user.increaseMoney(bet);
        } else {
            user.reduceMoney(bet);
        }
    }

    public long makeBet() {
        System.out.println("Сделайте ставку:");
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

    private boolean guessUsersNumber(int numberToGuess, int currentTry) {
        currentTry++;
        if (checkCountOfTries(currentTry)) {
            System.out.println("Проигрыш! Вы исчерпали количество попыток. Было загадано число - " + numberToGuess);
            return true;
        }
        System.out.println("Введите свой вариант: ");
        int enteredNumber = new Scanner(System.in).nextInt();
        if (enteredNumber>numberToGuess) {
            System.out.println("Неправильно! Загаданное число меньше.");
            guessUsersNumber(numberToGuess, currentTry);
        } else if (enteredNumber<numberToGuess) {
            System.out.println("Неправильно! Загаданное число больше.");
            guessUsersNumber(numberToGuess, currentTry);
        } else {
            if (currentTry==1) {
                System.out.println("Поздравляю!\nЧисло угадано с первого раза!\nВы выиграли двойную сумму ставки!");
            } else {
                System.out.println("Поздравляю!\nЧисло угадано\nВы выиграли!");
            }
        }
        return false;
    }

    private boolean checkCountOfTries(int currentTry) {
        return currentTry-1 == COUNT_OF_TRIES;
    }
}
