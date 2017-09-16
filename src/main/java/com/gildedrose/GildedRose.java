package com.gildedrose;

public class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            /* Update sellIn for all items except legendary items */
            if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS))
                ;
            else
                item.sellIn--;


            if (item.name.equals(AGED_BRIE)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            } else if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            } else if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {

            } else {
                item.quality = item.quality - 1; // Behaviour for a normal item
            }


            /* Update quality of the items that update quality depending on the sellIn property */
            if (item.sellIn < 0) {
                if (item.name.equals(AGED_BRIE)) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                } else if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                    item.quality = 0;
                } else if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    ;
                }
            }


        }
    }
}