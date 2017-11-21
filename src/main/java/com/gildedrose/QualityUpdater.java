package com.gildedrose;


public abstract class QualityUpdater {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    public static final int MAX_QUAILITY = 50;
    public static final int LEGENDARY_QUALITY = 80;

    Item item;

    public QualityUpdater(Item item) {
        this.item = item;
    }

    public static QualityUpdater classify(Item item) {

        String name = item.name;
        if (name.equals(AGED_BRIE))
            return new AgedBrieQualityUpdater(item);
        else if (name.equals(SULFURAS_HAND_OF_RAGNAROS))
            return new SulfurasQualityUpdater(item);
        else if (name.equals(BACKSTAGE_PASSES))
            return new BackstagePassesQualityUpdater(item);
        else if (name.equals(CONJURED_MANA_CAKE))
            return new MagicItemQualityUpdater(item);
        else
            return new CommonQualityUpdater(item);

    }

    public void update() {
        updateQuality();
        decreaseSellIn();
    }

    protected abstract void updateQuality();

    protected void decreaseSellIn() {
        item.sellIn--;
    }

}
