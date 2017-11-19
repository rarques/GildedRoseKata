package com.gildedrose;

public class CommonQualityUpdater extends QualityUpdater {

    public CommonQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
        item.sellIn--;
    }

    private void decreaseQuality() {
        if (item.quality > 0)
            if (item.sellIn == 0)
                item.quality -= 2;
            else
                item.quality--;
    }
}
