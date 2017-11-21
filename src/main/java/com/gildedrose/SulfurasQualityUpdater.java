package com.gildedrose;

public class SulfurasQualityUpdater extends QualityUpdater {

    public SulfurasQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.quality = LEGENDARY_QUALITY;
    }

    @Override
    protected void decreaseSellIn() {
        // Legendary items never expire!!
    }
}
