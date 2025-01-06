package com.gildedrose.inventory;

import com.gildedrose.Item;

public class Conjured extends InventoryItem {
    public static final String NAME = "Conjured";

    public Conjured(Item item) {
        super();
        this.item = item;
    }

    @Override
    protected void decreaseQuality() {
        item.quality = Math.max(0, item.quality - 2);
    }
}
