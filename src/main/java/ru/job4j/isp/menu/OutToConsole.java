package ru.job4j.isp.menu;

public class OutToConsole implements Out {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
