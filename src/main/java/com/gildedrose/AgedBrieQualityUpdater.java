package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {

    public AgedBrieQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        item.sellIn--;

        if (outOfSellingPeriod() && canIncreaseQuality())
            item.quality += 2;
        else if (canIncreaseQuality())
            item.quality++;
    }

}
