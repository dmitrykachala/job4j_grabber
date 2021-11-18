package ru.job4j.isp;

public interface Sender {

    boolean sendText();

    boolean sendVoice();

    boolean sendByEmail();

    boolean sendByPigeon();
}
