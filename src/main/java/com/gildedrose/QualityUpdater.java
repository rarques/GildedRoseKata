package com.gildedrose;

public class QualityUpdater {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    protected Item item;

    public QualityUpdater(Item item) {
        this.item = item;
    }

    public void updateItemQuality() {
        item.sellIn--;
        if (outOfSellingPeriod())
            item.quality -= 2;
        else
            item.quality--;
    }

    public static QualityUpdater classifyItem(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrieQualityUpdater(item);
            case BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT:
                return new BackstagePassQualityUpdater(item);
            case SULFURAS_HAND_OF_RAGNAROS:
                return new LegendaryItemQualityUpdater(item);
            case CONJURED_MANA_CAKE:
                return new ConjuredItemQualityUpdater(item);
            default:
                return new QualityUpdater(item);
        }
    }

    protected boolean canIncreaseQuality() {
        return item.quality < 50;
    }

    protected boolean outOfSellingPeriod() {
        return item.sellIn < 0;
    }
}