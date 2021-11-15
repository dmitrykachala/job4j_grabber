package ru.job4j.ocp;

import java.io.File;

public class Saver {

    public File save(String content) {
        return null;
    }

    public class InfoToFile {

        private Saver saver;

        public void getInfo(String info) {
            saver.save(info);
        }
    }
}
