package com.gildedrose.inventory;

import com.gildedrose.Item;

public class Sulfuras extends InventoryItem {
    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(Item item) {
        super();
        this.item = item;
    }

    @Override
    protected void decreaseSellIn() {
        // Do nothing
    }

    @Override
    protected void decreaseQuality() {
        // Do nothing
    }

    @Override
    protected void increaseQuality() {
        // Do nothing
    }
}
