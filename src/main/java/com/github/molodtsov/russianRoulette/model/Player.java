package com.github.molodtsov.russianRoulette.model;

import javax.persistence.*;

@Entity
@Table(name = "PLAYERS")
public class Player {
    @Column(length = 50)
    private String name;
    @Id
    @Column(length = 20)
    private String login;
    @Column(length = 20)
    private String password;
    @Column
    private int money;
    @Column
    private int win;
    @Column
    private int lose;

    //CONSTRUCTORS

    public Player(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.money = 10;
        this.win = 0;
        this.lose = 0;
    }

    public Player() {
    }

    //GETTERS & SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getLose() {
        return lose;
    }

//ADDITIONAL LOGIC

    public void addWin() {
        this.win ++;
    }

    public void addLose() {
        this.lose ++;
    }
}
