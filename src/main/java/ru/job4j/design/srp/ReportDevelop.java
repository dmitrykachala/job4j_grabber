package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportDevelop implements Report {

    private Store store;

    public ReportDevelop(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String start = "<table>";
        String startStr = "<tr><td>";
        String endStr = "</td></tr>";
        String end = "</table";
        String delimiter = "</td><td>";

        StringBuilder text = new StringBuilder();
        text.append(start)
                .append(startStr)
                .append("Name")
                .append(delimiter)
                .append("Hired")
                .append(delimiter)
                .append("Fired")
                .append(delimiter)
                .append("Salary")
                .append(endStr);
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(startStr)
                    .append(employee.getName())
                    .append(delimiter)
                    .append(employee.getHired())
                    .append(delimiter)
                    .append(employee.getFired())
                    .append(delimiter)
                    .append(employee.getSalary())
                    .append(endStr);
        }
        text.append(end);
        return text.toString();
    }

}
