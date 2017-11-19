package com.gildedrose;

public class MagicItemQualityUpdater extends QualityUpdater {

    public MagicItemQualityUpdater(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        item.quality -= 2;
    }

}
