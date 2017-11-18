package com.gildedrose;


public class QualityUpdater {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private Item item;

    public QualityUpdater(Item item) {
        this.item = item;
    }

    public static QualityUpdater classify(Item item) {

        if (item.name.equals(AGED_BRIE))
            return new AgedBrieQualityUpdater(item);
        else if (item.name.equals("notCommonItem"))
            throw new UnsupportedOperationException("Not implemented");
        else
            return new CommonQualityUpdater(item);

    }

    public void updateQuality() {

        // AgedBrieUpdater
        if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES)) {
            if (item.quality > 0) {
                if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {

            if (item.quality < 50) {
                // AgedBrie update
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


        // SulfurasUpdater
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
