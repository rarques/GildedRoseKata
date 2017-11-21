package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        System.out.println("-----> Updating items in warehouse... <-----");
        for (Item item : items) {
            System.out.println("Updating item: " + item.name);
            QualityUpdater updater = QualityUpdater.classify(item);
            updater.update();
            System.out.println("==> The item with name: " + item.name + " has been updated: ");
            System.out.println("\t" + "Quality: " + item.quality);
            System.out.println("\t" + "Sell-in: " + item.sellIn);
        }
    }

}