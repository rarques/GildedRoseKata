package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {

    public AgedBrieQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        item.sellIn--;

        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }

        }
    }
}
