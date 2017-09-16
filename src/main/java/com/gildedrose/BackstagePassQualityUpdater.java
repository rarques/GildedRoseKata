package com.gildedrose;

public class BackstagePassQualityUpdater extends QualityUpdater {

    public BackstagePassQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        item.sellIn--;

        if (outOfSellingPeriod())
            item.quality = 0;

        else if (canIncreaseQuality()) {
            item.quality++;
            if (concertIsImminent() && canIncreaseQuality())
                item.quality += 2;
            else if (concertIsNear() && canIncreaseQuality())
                item.quality++;
        }
    }

    private boolean concertIsNear() {
        return item.sellIn < 11;
    }

    private boolean concertIsImminent() {
        return item.sellIn < 6;
    }

}
