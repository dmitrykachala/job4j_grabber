package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {

    private static DirFileCache dfc;

    public static DirFileCache cacheDir(String dir) {
        return new DirFileCache(dir);
    }

    public static void main(String[] args) {

        boolean menu = true;
        while (menu) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Указать кэшируемую директорию");
            System.out.println("2. Загрузить файл в кэш");
            System.out.println("3. Вызвать файл из кэша");
            System.out.println("4. Выход");
            System.out.print("Выберете желаемое действие: ");
            String answer = scanner.nextLine();
            if (answer.equals("1")) {
                System.out.print("Введите директорию: ");
                String dir = scanner.nextLine();
                dfc = cacheDir(dir);
                continue;
            }
            if (answer.equals("2")) {
                System.out.print("Введите имя файла: ");
                String fileName = scanner.nextLine();
                dfc.load(fileName);
                continue;
            }
            if (answer.equals("3")) {
                System.out.print("Введите имя файла: ");
                String fileName = scanner.nextLine();
                System.out.println(dfc.get(fileName));
                continue;
            }
            if (answer.equals("4")) {
                System.out.println("bye");
                menu = false;
            }
        }
    }
}