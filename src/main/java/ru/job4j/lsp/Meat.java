package ru.job4j.lsp;

import java.util.Date;

public class Meat extends Food {
    public Meat(Date expiryDate, Date createDate, double price, double discount) {
        super("Meat", expiryDate, createDate, price, discount);
    }
}
