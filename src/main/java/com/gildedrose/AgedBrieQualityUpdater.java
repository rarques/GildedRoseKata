package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {

    public AgedBrieQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        item.sellIn--;

        if (canIncreaseQuality()) {
            item.quality++;
        }

        if (canBeSold() && canIncreaseQuality()) {
            item.quality++;
        }
    }

}
