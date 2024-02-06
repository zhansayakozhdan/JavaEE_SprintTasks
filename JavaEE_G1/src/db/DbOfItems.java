package db;

import models.Item;

import java.util.ArrayList;
import java.util.List;

public class DbOfItems {
    private static List<Item> items = new ArrayList<>();

    static {
        items.add(new Item(1l, "Iphone", 500000, 100));
        items.add(new Item(2l, "Iphone", 500000, 100));
        items.add(new Item(3l, "Iphone", 500000, 100));
        items.add(new Item(4l, "Iphone", 500000, 100));
        items.add(new Item(5l, "Iphone", 500000, 100));
    }


}
