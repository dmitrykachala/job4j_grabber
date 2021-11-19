package ru.job4j.lsp.food;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

    public class ControlQuality {

        private List<Store> storage;

        public ControlQuality(List<Store> storage) {
            this.storage = storage;
        }

        public void distribute(Food food) {
            for (Store store : storage) {
                if (store.accept(food)) {
                    store.save(food);
                    break;
                }
            }
        }

        public static void main(String[] args) {
            Date future10 = asDate(LocalDate.now().plusDays(10));
            Date future100 = asDate(LocalDate.now().plusDays(100));
            Date past10 = asDate(LocalDate.now().minusDays(10));
            Date past100 = asDate(LocalDate.now().minusDays(100));
            List<Food> products = List.of(
                    new Food("Food1", future10, new Date(), 100, 0),
                    new Food("Food2", past10, past100, 100, 0),
                    new Milk(future10, past10, 100, 0),
                    new Meat(future10, past100, 100, 0));
            sorter(products);
        }

        public static Date asDate(LocalDate localDate) {
            return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        }

        public static void sorter(List<Food> food) {

            ControlQuality cq = new ControlQuality(List.of(new WarehouseStore(),
                    new ShopStore(), new TrashStore()));
            food.forEach(cq::distribute);

            System.out.println(cq.storage.get(0).findBy(f -> true));
            System.out.println(cq.storage.get(1).findBy(f -> true));
            System.out.println(cq.storage.get(2).findBy(f -> true));
        }
    }

