package com.gildedrose;

public class ConjuredItemQualityUpdater extends QualityUpdater {

    public ConjuredItemQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        if (outOfSellingPeriod())
            item.quality -= 4;
        else
            item.quality -= 2;
    }
}
