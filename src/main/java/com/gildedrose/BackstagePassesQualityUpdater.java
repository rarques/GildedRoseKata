package com.gildedrose;

public class BackstagePassesQualityUpdater extends QualityUpdater {

    public BackstagePassesQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.sellIn <= 10)
            item.quality += 2;
        if (item.sellIn <= 5)
            item.quality++;
        if (item.sellIn <= 0)
            item.quality = 0;

        item.sellIn--;
    }
}
