package com.gildedrose;

import com.gildedrose.inventory.InventoryItem;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void dailyUpdate() {
        for (Item item : items) {
            InventoryItem.create(item).updateItem();
        }
    }



}
