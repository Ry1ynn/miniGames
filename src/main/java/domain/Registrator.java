package domain;

/**
 * Базовый интерфейс для регистрации пользователя.
 */

public interface Registrator {

    /**
     * Регистрация пользователя.
     * @return Зарегистрированный пользователь.
     */

    User registerUser();
}
