package ru.job4j.grabber.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import static java.util.Map.entry;

public class SqlRuDateTimeParser implements DateTimeParser {

    private static final Map<String, String> MONTHS = Map.ofEntries(
            entry("янв", "01"), entry("фев", "02"),
            entry("мар", "03"), entry("апр", "04"),
            entry("май", "05"), entry("июн", "06"),
            entry("июл", "07"), entry("авг", "08"),
            entry("сен", "09"), entry("окт", "10"),
            entry("ноя", "11"), entry("дек", "12")
    );

    @Override
    public LocalDateTime parse(String parse) {
        String day;
        String month;
        String year;
        String time;
        String[] strFull = parse.split(", ");
        time = strFull[1];
        String[] timeSplit = time.split(":");
        int hour = Integer.parseInt(timeSplit[0]);
        int min = Integer.parseInt(timeSplit[1]);
        String[] strDate = strFull[0].split(" ");
        if (strDate.length == 3) {
            month = MONTHS.get(strDate[1]);
            day = strDate[0];
            year = "20" + strDate[2];
            return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month),
                    Integer.parseInt(day), hour, min);
        }

        LocalDateTime today = LocalDateTime.of(LocalDateTime.now().getYear(),
                LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth(),
                hour, min);
        if (strDate[0].equals("сегодня")) {
            return today;
        }
        if (strDate[0].equals("вчера")) {
            return today.minusDays(1);
        }
        return null;
    }

    public static void main(String[] args) {
        SqlRuDateTimeParser sqlP = new SqlRuDateTimeParser();
        System.out.println(sqlP.parse("12 май 20, 02:30"));
        System.out.println(sqlP.parse("вчера, 03:30"));
        System.out.println(sqlP.parse("сегодня, 04:30"));
    }
}
