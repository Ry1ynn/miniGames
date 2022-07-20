package Impl;

import domain.User;

import java.util.Scanner;

public class Checker {

    public boolean isUserAvailableToPlay(User user) {
        if (user.getMoney() == 0) {
            System.out.println("На вашем балансе недостаточно средств. Пополнить?\n* Да\n* Нет");
            String usersAnswer = new Scanner(System.in).nextLine();
            if (usersAnswer.equalsIgnoreCase("Да")) {
                user.increaseMoney(1000);
                return true;
            } else if (usersAnswer.equalsIgnoreCase("Нет")) {
                return false;
            } else {
                isUserAvailableToPlay(user);
            }
        }
        return true;
    }
}
