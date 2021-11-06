package ru.job4j.gc;

public class User {

    private String login;
    private String pass;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %s %s%n", login, pass);
        System.out.println(System.lineSeparator());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
