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
        updateExpired();
    }

    protected void updateExpired() {
        if (item.sellIn < 0) {
            if (item.name.equals(AgedBrie.NAME)) {
                increaseQuality();
            } else if (item.name.equals(BackstagePass.NAME)) {
                item.quality = 0;
            } else if (item.quality > 0 && !item.name.equals(Sulfuras.NAME)) {
                decreaseQuality();
            }
        }
    }

    protected void updateQuality() {
        if (item.name.equals(AgedBrie.NAME) || item.name.equals(BackstagePass.NAME)) {
            increaseQuality();

            if (item.name.equals(BackstagePass.NAME)) {
                if (item.sellIn < 10) {
                    increaseQuality();
                }

                if (item.sellIn < 5) {
                    increaseQuality();
                }
            }
        } else if (item.quality > 0) {
            decreaseQuality();
        }
    }

    protected void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    protected void decreaseQuality() {
        item.quality -= 1;
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }
}
