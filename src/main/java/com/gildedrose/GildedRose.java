package com.gildedrose;

public class GildedRose {

    private final QualityUpdater qualityUpdater = new QualityUpdater();

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            qualityUpdater.updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        qualityUpdater.updateItemQuality(item);
    }
}