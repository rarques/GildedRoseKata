package com.gildedrose;

public class SulfurasQualityUpdater extends QualityUpdater {

    public SulfurasQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        updateQuality();
    }

    @Override
    public void updateQuality() {
        item.quality = LEGENDARY_QUALITY;
    }
}
