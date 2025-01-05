package com.gildedrose.inventory;

import com.gildedrose.Item;

public class InventoryItem {
    protected Item item;

    public static InventoryItem create(Item item) {
        switch (item.name) {
            case AgedBrie.NAME:
                return new AgedBrie(item);
            case BackstagePass.NAME:
                return new BackstagePass(item);
            case Sulfuras.NAME:
                return new Sulfuras(item);
            default:
                return new StandardItem(item);
        }
    }
}
