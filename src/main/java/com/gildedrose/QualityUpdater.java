package com.gildedrose;

public class QualityUpdater {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    protected Item item;

    public QualityUpdater(Item item) {
        this.item = item;
    }

    public void updateItemQuality() {
        item.sellIn--;
        item.quality--;
    }

    public static QualityUpdater classifyItem(Item item) {
        if (item.name.equals(AGED_BRIE))
            return new AgedBrieQualityUpdater(item);
        else if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT))
            return new BackstagePassQualityUpdater(item);
        else if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS))
            return new LegendaryItemQualityUpdater(item);
        else
            return new QualityUpdater(item);
    }
}