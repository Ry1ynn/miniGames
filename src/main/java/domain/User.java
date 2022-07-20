package domain;

/**
 * Базовый интерфейс пользователя.
 */

public interface User {

    /**
     * Увеличение счета пользователя.
     * @param amount Сумма.
     */

    void increaseMoney(long amount);

    /**
     * Уменьшение счета пользователя.
     * @param amount Сумма.
     */

    void reduceMoney(long amount);

    /**
     * Имя пользователя.
     */

    String getName();


    /**
     * Счет пользователя.
     */

    long getMoney();
}
