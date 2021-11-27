package ru.job4j.isp.menu;

public interface MenuInterface {

    void add(String parentName, String childName, Action action);

    Action select(String nodeName);

    String print(String level);
}
