package Impl;

import domain.Game;
import domain.User;

import java.util.Random;
import java.util.Scanner;

public class SuEeFa implements Game {

    private static final int COUNT_OF_SHOTS = 3;

    private int counter;

   private int userPoints=0;
   private int systemPoints=0;

    private final User user;

    public SuEeFa(User user) { this.user = user; }


    @Override
    public void play() {

        long bet = makeBet();
        int currentTry = 0;

        int[] suefa = {0,1,2};

        int systemAnswerType = 0;
        System.out.println("Игра в камень, ножницы, бумага.\nСыграйте " + COUNT_OF_SHOTS + " раза с программой");
        makeShots(systemAnswerType,currentTry);
        if (counter==1) {
            user.increaseMoney(bet);
            System.out.println("проверка+");
        } else {
            user.reduceMoney(bet);
        }

    }

    @Override
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

    private void makeShots(int systemAnswerType, int currentTry) {
        currentTry++;

        int userAnswerType;

        systemAnswerType = new Random().nextInt(3);

        if (userPoints==2) {
            System.out.println("Подравляем! Вы выиграли.");
            counter++;
            return;
        }
        if (systemPoints==2) {
            System.out.println("Вы проиграли!");
            counter+=2;
            return;
        }

        System.out.println("Введите: \n* Камень\n* Ножницы\n* Бумага ");
        String userAnswer = new Scanner(System.in).nextLine();
        if (userAnswer.equalsIgnoreCase("Бумага")) {
            userAnswerType=0;
            if (systemAnswerType==0) {
                System.out.println("Программа выбрала бумагу.Ничья.\n Играем заново:");
                currentTry--;
                makeShots(systemAnswerType,currentTry);
            } else if (systemAnswerType==1) {
                System.out.println("Программа выбрала ножницы. Вы проиграли.\n Играем дальше:");
                systemPoints++;
                makeShots(systemAnswerType,currentTry);
            } else {
                System.out.println("Программа выбрала камень. Вы выиграли.\n Играем дальше:");
                userPoints++;
                makeShots(systemAnswerType,currentTry);
            }
        } else if (userAnswer.equalsIgnoreCase("Ножницы")) {
            userAnswerType=1;
            if (systemAnswerType==0) {
                System.out.println("Программа выбрала бумагу. Вы выиграли.\n Играем дальше:");
                userPoints++;
                makeShots(systemAnswerType,currentTry);
            } else if (systemAnswerType==1) {
                System.out.println("Программа выбрала ножницы. Ничья.\n Играем заново:");
                currentTry--;
                makeShots(systemAnswerType,currentTry);
            } else {
                System.out.println("Программа выбрала камень. Вы проиграли\n Играем дальше:");
                systemPoints++;
                makeShots(systemAnswerType,currentTry);
            }
        } else if (userAnswer.equalsIgnoreCase("Камень")) {
            userAnswerType=2;
            if (systemAnswerType==0) {
                System.out.println("Программа выбрала бумагу. Вы проиграли.\n Играем дальше:");
                systemPoints++;
                makeShots(systemAnswerType,currentTry);
            } else if (systemAnswerType==1) {
                System.out.println("Программа выбрала ножницы. Вы выиграли.\n Играем дальше:");
                userPoints++;
                makeShots(systemAnswerType,currentTry);
            } else {
                System.out.println("Программа выбрала камень. Ничья.\n Играем заново:");
                currentTry--;
                makeShots(systemAnswerType,currentTry);
            }
        } else {
            System.out.println("Некорректный ввод, введите заново: ");
            currentTry--;
            makeShots(systemAnswerType,currentTry);
        }
    }
}
