package ru.job4j.lsp;

import java.util.Date;

public class Milk extends Food {
    public Milk(Date expiryDate, Date createDate, double price, double discount) {
        super("Milk", expiryDate, createDate, price, discount);
    }
}
