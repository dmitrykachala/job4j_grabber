package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Sidor", now, now, 10);
        store.add(worker);
        store.add(worker2);
        Report engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));

    }

    @Test
    public void whenDevelopGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportDevelop(store);
        StringBuilder expect = new StringBuilder()
                .append("<table>")
                .append("<tr><td>")
                .append("Name")
                .append("</td><td>")
                .append("Hired")
                .append("</td><td>")
                .append("Fired")
                .append("</td><td>")
                .append("Salary")
                .append("</td></tr>")
                .append(System.lineSeparator())
                .append("<tr><td>")
                .append(worker.getName())
                .append("</td><td>")
                .append(worker.getHired())
                .append("</td><td>")
                .append(worker.getFired())
                .append("</td><td>")
                .append(worker.getSalary())
                .append("</td></tr>")
                .append("</table")
                /*.append(System.lineSeparator())*/;
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenAccountingGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportAccounting(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() - worker.getSalary() * 0.13).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}