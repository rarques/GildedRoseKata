package com.gildedrose;

public class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityUpdater qualityUpdater = QualityUpdater.classifyItem(item);
            qualityUpdater.updateItemQuality();
        }
    }

}