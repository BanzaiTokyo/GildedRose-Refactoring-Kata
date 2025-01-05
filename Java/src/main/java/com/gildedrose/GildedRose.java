package com.gildedrose;

import com.gildedrose.inventory.AgedBrie;
import com.gildedrose.inventory.BackstagePass;
import com.gildedrose.inventory.Sulfuras;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void dailyUpdate() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private static void updateItem(Item item) {
        if (!item.name.equals(Sulfuras.NAME)) {
            decreaseSellIn(item);
        }
        updateQuality(item);
    }


    private static void updateQuality(Item item) {
        if (item.name.equals(AgedBrie.NAME) || item.name.equals(BackstagePass.NAME)) {
            if (item.quality < 50) {
                increaseQuality(item);

                if (item.name.equals(BackstagePass.NAME)) {
                    if (item.sellIn < 10 && item.quality < 50) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 5 && item.quality < 50) {
                        increaseQuality(item);
                    }
                }
            }
        } else if (!item.name.equals(Sulfuras.NAME) && item.quality > 0) {
            decreaseQuality(item);
        }



        if (item.sellIn < 0) {
            if (item.name.equals(AgedBrie.NAME)) {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            } else if (item.name.equals(BackstagePass.NAME)) {
                item.quality = 0;
            } else if (item.quality > 0 && !item.name.equals(Sulfuras.NAME)) {
                decreaseQuality(item);
            }
        }

    }

    private static void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private static void decreaseQuality(Item item) {
        item.quality -= 1;
    }

    private static void increaseQuality(Item item) {
        item.quality += 1;
    }
}
