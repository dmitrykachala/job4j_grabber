package ru.job4j.quartz;

import org.junit.Test;

import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AlertRabbitTest {

    @Test
    public void whenGetPropertiesThenArguments() {
        Properties properties = AlertRabbit.getProperties("rabbit.properties");
        assertThat(properties.getProperty("rabbit.interval"), is("5"));
    }
}