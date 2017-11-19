package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {

    public AgedBrieQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
    }

    private void increaseQuality() {
        if (item.quality < MAX_QUAILITY) {
            item.quality += (item.sellIn <= 0) ? 2 : 1;
        }
    }
}
