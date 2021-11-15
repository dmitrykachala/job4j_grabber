package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mchange.v2.lang.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngine implements Report {

    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public static void main(String[] args) throws JAXBException {
        Employee employee = new Employee("Sidor", Calendar.getInstance(),
                Calendar.getInstance(), 500.3);
        Employee employee1 = new Employee("Sdor", Calendar.getInstance(),
                Calendar.getInstance(), 50.3);
        Employee employee2 = new Employee("dor", Calendar.getInstance(),
                Calendar.getInstance(), 1500.3);
        MemStore store = new MemStore();
        store.add(employee);
        store.add(employee1);
        store.add(employee2);
        ReportXML rx = new ReportXML(store);
        ReportJSON rj = new ReportJSON(store);
        System.out.println(rj.generate(em -> em.getSalary() < 100));
        System.out.println(rx.generate(em -> em.getSalary() > 100));
    }
}
