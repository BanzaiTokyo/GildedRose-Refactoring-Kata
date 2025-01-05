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

    public void updateItem() {
        if (!this.item.name.equals(Sulfuras.NAME)) {
            decreaseSellIn();
        }
        updateQuality();
        updateExpired();
    }

    private void updateExpired() {
        if (item.sellIn < 0) {
            if (item.name.equals(AgedBrie.NAME)) {
                if (item.quality < 50) {
                    increaseQuality();
                }
            } else if (item.name.equals(BackstagePass.NAME)) {
                item.quality = 0;
            } else if (item.quality > 0 && !item.name.equals(Sulfuras.NAME)) {
                decreaseQuality();
            }
        }
    }

    private void updateQuality() {
        if (item.name.equals(AgedBrie.NAME) || item.name.equals(BackstagePass.NAME)) {
            if (item.quality < 50) {
                increaseQuality();

                if (item.name.equals(BackstagePass.NAME)) {
                    if (item.sellIn < 10 && item.quality < 50) {
                        increaseQuality();
                    }

                    if (item.sellIn < 5 && item.quality < 50) {
                        increaseQuality();
                    }
                }
            }
        } else if (!item.name.equals(Sulfuras.NAME) && item.quality > 0) {
            decreaseQuality();
        }
    }

    private  void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    private  void decreaseQuality() {
        item.quality -= 1;
    }

    private  void increaseQuality() {
        item.quality += 1;
    }

}
