package com.jrpanda.Economy;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class EconManager {
    private HashMap<Player, Double> balances;

    public EconManager() {
        this.balances = new HashMap<>();
    }

    public double getBalance(Player player) {
        return balances.getOrDefault(player, 0.0);
    }

    public void deposit(Player player, double amount) {
        balances.put(player, getBalance(player) + amount);
    }

    public void withdraw(Player player, double amount) {
        balances.put(player, getBalance(player) - amount);
    }

}
