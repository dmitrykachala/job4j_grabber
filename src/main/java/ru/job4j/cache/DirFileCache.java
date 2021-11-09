package ru.job4j.cache;

import java.io.FileInputStream;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        try (FileInputStream fis = new FileInputStream(cachingDir.concat("\\\\").concat(key))) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = fis.read()) != -1) {
                text.append((char) read);
            }
            put(key, text.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DirFileCache dfc = new DirFileCache("test");
        dfc.load("2.txt");
        System.out.println(dfc.get("2.txt"));
    }

}