package com.gildedrose.inventory;

import com.gildedrose.Item;

public class BackstagePass extends InventoryItem {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePass(Item item) {
        super();
        this.item = item;
    }

    @Override
    protected void updateQuality() {
        increaseQuality();

        if (item.sellIn < 10) {
            increaseQuality();
        }

        if (item.sellIn < 5) {
            increaseQuality();
        }
    }

    @Override
    protected void updateExpired() {
        item.quality = 0;
    }
}
