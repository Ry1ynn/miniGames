package Impl;

import domain.Game;
import domain.GameChooser;
import domain.User;

import java.util.Scanner;

public class GameChooserImpl implements GameChooser {
    @Override
    public Game chooseGame(User user) {
        System.out.println("Выберите игру:\n* Угадать число\n* Загадать число\n* Суефа ");
        String gameName = new Scanner(System.in).nextLine();
        int counter = 0;
        while (counter == 0) {
            if (gameName.equalsIgnoreCase("Угадать число")) {
                counter = 1;
                return new GuessNumberGame(user);
            } else if (gameName.equalsIgnoreCase("Загадать число")) {
                counter = 1;
                return new ThinkOfNumberGame(user);
            } else if (gameName.equalsIgnoreCase("Суефа")) {
                counter = 1;
                return new SuEeFa(user);
            } else {
                System.out.println("Введено некорректное название игры");
                gameName = new Scanner(System.in).nextLine();
            }
        }
        return null;
    }
}
