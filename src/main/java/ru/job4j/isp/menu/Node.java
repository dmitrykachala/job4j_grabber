package ru.job4j.isp.menu;

import java.util.List;

public class Node implements Menu {

    private Node parent;
    private Out out;
    private List<Node> children;

    public Node(Out out) {
        this.out = out;
    }

    public boolean add(Node child) {
        return false;
    }

    public boolean remove(Node child) {
        return false;
    }

    @Override
    public String name() {
        return "name";
    }

    @Override
    public boolean execute() {
        return false;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
