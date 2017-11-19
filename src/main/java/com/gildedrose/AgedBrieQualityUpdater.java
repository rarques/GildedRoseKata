package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {

    public AgedBrieQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
        item.sellIn--;
    }

    private void increaseQuality() {
        item.quality++;
    }
}
