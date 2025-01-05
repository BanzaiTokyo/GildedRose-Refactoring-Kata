package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String PASSES = "Backstage passes to a TAFKAL80ETC concert";
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
        if (!item.name.equals(AGED_BRIE)
            && !item.name.equals(PASSES)) {
            if (item.quality > 0) {
                if (!item.name.equals(SULFURAS)) {
                    decreaseQuality(item);
                }
            }
        } else {
            if (item.quality < 50) {
                increaseQuality(item);

                if (item.name.equals(PASSES)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            increaseQuality(item);
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            increaseQuality(item);
                        }
                    }
                }
            }
        }

        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(PASSES)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(SULFURAS)) {
                            decreaseQuality(item);
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }
        }
    }

    private static void decreaseQuality(Item item) {
        item.quality -= 1;
    }

    private static void increaseQuality(Item item) {
        item.quality += 1;
    }
}
