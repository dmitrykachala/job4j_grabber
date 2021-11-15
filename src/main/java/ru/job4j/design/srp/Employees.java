package ru.job4j.design.srp;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {

    private List<Employee> employees;

    public Employees() {
    }

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getUsers() {
        return employees;
    }

    public void setUsers(List<Employee> employees) {
        this.employees = employees;
    }
}
