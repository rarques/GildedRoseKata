package com.gildedrose;


public class QualityUpdater {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public static final int MAX_QUAILITY = 50;

    Item item;

    public QualityUpdater(Item item) {
        this.item = item;
    }

    public static QualityUpdater classify(Item item) {

        String name = item.name;
        if (name.equals(AGED_BRIE))
            return new AgedBrieQualityUpdater(item);
        else if (name.equals(SULFURAS_HAND_OF_RAGNAROS))
            return new SulfurasQualityUpdater(item);
        else if (name.equals(BACKSTAGE_PASSES))
            return new BackstagePassesQualityUpdater(item);
        else
            return new CommonQualityUpdater(item);

    }

    public void updateQuality() {

        // CommonItemUpdater
        if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES)) {
//            if (item.quality > 0) {
//                if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
//                    item.quality = item.quality - 1;
//                }
//            }
        } else {

            if (item.quality < 50) {
                increaseQuality(item);

                if (item.name.equals(BACKSTAGE_PASSES)) {
                    // BackStageUpdater
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


        // all except sulfuras updater
        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn = item.sellIn - 1;
        }


        // Items out of selling date
        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                            // CommonItemUpdate
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

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

}
