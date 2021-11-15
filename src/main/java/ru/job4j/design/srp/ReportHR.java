package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportHR implements Report {

    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter)
                .stream().sorted((e1, e2) ->
                        Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee employee : employees) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }

}
