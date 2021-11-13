package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.tdd.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GeneratorTmpTest {

    @Ignore
    @Test
    public void whenCorrectParameters() {
        GeneratorTmp generator = new GeneratorTmp();
        String template = "I am ${name}, I am ${subject}!";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Yoda");
        map.put("subject", "Jedi");
        String rsl = generator.produce(template, map);
        String expected = "I am Yoda, I am Jedi!";
        assertThat(expected, is(rsl));
    }

    @Ignore
    @Test(expected = Exception.class)
    public void whenWrongTemplate() {
        GeneratorTmp generator = new GeneratorTmp();
        String template = "This ${object}, is used for ${purpose}!";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Yoda");
        map.put("subject", "Jedi");
        String rsl = generator.produce(template, map);
    }

    @Ignore
    @Test(expected = Exception.class)
    public void whenWrongParameters() {
        GeneratorTmp generator = new GeneratorTmp();
        String template = "I am ${name}, I am ${subject}!";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Yoda");
        map.put("subject", "Jedi");
        map.put("object", "train");
        String rsl = generator.produce(template, map);
    }
}