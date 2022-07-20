package App;

import Impl.Checker;
import Impl.GameChooserImpl;
import Impl.RegistratorImpl;
import Impl.UserImpl;
import domain.Game;
import domain.GameChooser;
import domain.Registrator;
import domain.User;

public class Application {
    public static void main(String[] args) {
        Registrator registrator = new RegistratorImpl();
        GameChooser gameChooser = new GameChooserImpl();
        User user = registrator.registerUser();
        Checker checker = new Checker();
        do {
            Game game = gameChooser.chooseGame(user);
            game.play();
            System.out.println(user.getName() + ", у тебя на счете " + user.getMoney());
        } while (checker.isUserAvailableToPlay(user));
    }
}
