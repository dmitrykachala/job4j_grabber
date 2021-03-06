package ru.job4j.lsp.food;

import java.util.List;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

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
            ControlQuality cq = new ControlQuality(List.of(new WarehouseStore(), new ShopStore(),
                    new TrashStore()));
            cq.sorter(products);
            cq.resort();
        }

        public static Date asDate(LocalDate localDate) {
            return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        }

        public void sorter(List<Food> food) {

            food.forEach(this::distribute);

            System.out.println(storage.get(0).findBy(f -> true));
            System.out.println(storage.get(1).findBy(f -> true));
            System.out.println(storage.get(2).findBy(f -> true));

        }

        public void resort() {

            List<Food> lsForResort = storage.stream()
                    .map(s -> s.findBy(f -> true))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            storage.forEach(Store::clean);
            sorter(lsForResort);
        }
    }

