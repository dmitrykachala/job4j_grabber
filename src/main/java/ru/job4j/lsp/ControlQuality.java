package ru.job4j.lsp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

    public class ControlQuality {

        public static void main(String[] args) {
            Date future10 = asDate(LocalDate.now().plusDays(10));
            Date future100 = asDate(LocalDate.now().plusDays(10));
            Date past10 = asDate(LocalDate.now().minusDays(10));
            Date past100 = asDate(LocalDate.now().minusDays(100));
            List<Food> products = List.of(
                    new Food("Food1", future10, new Date(), 100, 0),
                    new Food("Food2", past10, past100, 100, 0),
                    new Milk(future10, past10, 100, 0),
                    new Meat(future10, past100, 100, 0));
            new ControlQuality().sorter(products);
        }

        public static Date asDate(LocalDate localDate) {
            return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        }

        public void sorter(List<Food> food) {
            Store warehouse = new Store(new WarehouseStrategy());
            Store shop = new Store(new ShopStrategy());
            Store trash = new Store(new TrashStrategy());

            long lost = food.stream().filter(i -> !warehouse.apply(i)).filter(i ->
                    !shop.apply(i)).filter(i -> !trash.apply(i)).count();
            assert lost == 0;

            System.out.println(warehouse.findBy(f -> true));
            System.out.println(shop.findBy(f -> true));
            System.out.println(trash.findBy(f -> true));
        }
    }

