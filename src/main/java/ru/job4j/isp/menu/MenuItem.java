package ru.job4j.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuItem implements MenuInterface {

    private static final String SPACE = " ";
    private final Action action;
    private List<MenuItem> nodes = new ArrayList<>();
    private String name;

    public MenuItem(String childName, Action action) {
        this.name = childName;
        this.action = action;
    }

    @Override
    public void add(String parentName, String childName, Action action) {
        if (parentName.equals(name)) {
            nodes.add(new MenuItem(childName, action));
        } else {
            nodes.forEach(n -> n.add(parentName, childName, action));
        }
    }

    @Override
    public Action select(String nodeName) {
        if (name.equals(nodeName)) {
            return action;
        } else {
            for (MenuItem m : nodes) {
                Action a = m.select(nodeName);
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    @Override
    public String print(String level) {
        StringBuilder sb = new StringBuilder();
        sb.append(level).append(name).append("\r\n");
        nodes.forEach(n -> sb.append(n.print(level + SPACE)));
        return sb.toString();
    }
}
