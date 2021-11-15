package ru.job4j.ocp;

public class Log {

    public void log(String text) {

    }

    public class Mailer {

        private Log logger;

        public Mailer(Log logger) {
            this.logger = logger;
        }

        public void sendMsg(String msg) {
            logger.log("some text");
        }
    }
}
