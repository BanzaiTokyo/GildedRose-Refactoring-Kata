package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private static void updateItem(Item item) {
        if (item.name.equals(AGED_BRIE) || item.name.equals(BACKSTAGE)) {
            if (item.quality < 50) {
                increaseQuality(item);

                if (item.name.equals(BACKSTAGE)) {
                    if (item.sellIn <= 10 && item.quality < 50) {
                        increaseQuality(item);
                    }

                    if (item.sellIn <= 5 && item.quality < 50) {
                        increaseQuality(item);
                    }
                }
            }
        } else if (!item.name.equals(SULFURAS) && item.quality > 0) {
            decreaseQuality(item);
        }
        if (!item.name.equals(SULFURAS)) {
            decreaseSellIn(item);
        }


        if (item.sellIn < 0) {
            if (item.name.equals(AGED_BRIE)) {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            } else if (item.name.equals(BACKSTAGE)) {
                item.quality = 0;
            } else if (item.quality > 0 && !item.name.equals(SULFURAS)) {
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
