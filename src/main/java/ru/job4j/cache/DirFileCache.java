package ru.job4j.cache;

import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        try {
            return Files.readString(Path.of(cachingDir.concat("\\\\").concat(key)));
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