package com.gildedrose;

public class BackstagePassQualityUpdater extends QualityUpdater {

    public BackstagePassQualityUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        item.sellIn--;

        if (canIncreaseQuality()) {
            item.quality++;
            if (item.sellIn < 11) {
                if (canIncreaseQuality()) {
                    item.quality++;
                }
            }

            if (item.sellIn < 6) {
                if (canIncreaseQuality()) {
                    item.quality++;
                }
            }
        }

        if (canBeSold()) {
            if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                item.quality = 0;
            }
        }

    }
}
