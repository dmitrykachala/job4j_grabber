package ru.job4j.isp.menu;

public class DemoMenu {

    private MenuItem root;

    public DemoMenu() {
        root = new MenuItem("Root 1", null);
        root.add("Root 1", "Child 1.1", null);
        root.add("Root 1", "Child 1.2", null);
        root.add("Root 1", "Child 1.3", null);
        root.add("Child 1.1", "Child 1.1.1", null);
        root.add("Child 1.1", "Child 1.1.2", null);
    }

    public void print() {
        root.print("");
    }

    public static void main(String[] args) {
        new DemoMenu().print();
    }
}
