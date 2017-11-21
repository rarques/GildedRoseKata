package com.gildedrose;

import java.text.MessageFormat;
import java.util.ResourceBundle;

class GildedRose {

    private static final ResourceBundle i18n = ResourceBundle.getBundle("Bundle");
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        System.out.println(i18n.getString("updating.items.in.warehouse"));
        for (Item item : items) {
            System.out.println(MessageFormat.format(i18n.getString("updating.item.0"), item.name));
            QualityUpdater updater = QualityUpdater.classify(item);
            updater.update();
            System.out.println(MessageFormat.format(i18n.getString("the.item.with.name.0.has.been.updated"), item.name));
            System.out.println("\t" + MessageFormat.format(i18n.getString("quality.0"), item.quality));
            System.out.println("\t" + MessageFormat.format(i18n.getString("sell.in.0"), item.sellIn));
        }
    }

}