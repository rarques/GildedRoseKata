package com.gildedrose;

class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE)
                    && !item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality > 0) {
                    if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    increaseQuality(item);

                    if (item.name.equals(BACKSTAGE_PASSES)) {
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

            if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                item.quality = item.quality - 1;
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
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}