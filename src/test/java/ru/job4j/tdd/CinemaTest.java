package ru.job4j.tdd;

import static org.junit.Assert.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Ignore
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        assertTrue(cinema.find(s -> s.equals(session)).contains(session));
    }

    @Ignore
    @Test(expected = WrongTicketException.class)
    public void buyDuplicateTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Ticket ticketDuplicate = cinema.buy(account, 1, 1, date);
    }

    @Ignore
    @Test(expected = WrongDateException.class)
    public void buyWrongDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(1945, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }

    @Ignore
    @Test(expected = WrongSeatException.class)
    public void buyWrongSeat() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 150, 1000, date);
    }
}