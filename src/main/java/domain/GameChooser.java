package domain;

/**
 * Базовый интерфейс для выбора игры.
 */

public interface GameChooser {

    /**
     * Выбирает игру.
     * @param user
     * @return
     */

    Game chooseGame(User user);
}
