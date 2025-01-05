package com.gildedrose.inventory;

import com.gildedrose.Item;

public abstract class InventoryItem {
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

    public void updateItem() {
        decreaseSellIn();
        updateQuality();
        if (isExpired()) {
            updateExpired();
        }
    }

    private boolean isExpired() {
        return item.sellIn < 0;
    }

    protected void updateExpired() {
        decreaseQuality();
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }
}
