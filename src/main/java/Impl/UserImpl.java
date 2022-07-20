package Impl;

import domain.User;

public class UserImpl implements User {

    private static final long WELCOME_BONUS = 1000;
    private final String name;
    private long money;

    public UserImpl(String name) {
        this.name = name;
        this.money = WELCOME_BONUS;
    }

    @Override
    public void increaseMoney(long amount) {
        this.money += amount;
    }

    @Override
    public void reduceMoney(long amount) {
        if (this.money < amount) {
            this.money = 0;
        }
        this.money -= amount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getMoney() {
        return this.money;
    }
}
