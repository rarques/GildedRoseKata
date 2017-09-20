package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GildedRoseNoRegressionsTest {

    @Test
    public void noRegressions() {

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRoseBaseLine appBaseLine = new GildedRoseBaseLine(items);
        GildedRose app = new GildedRose(items);

        appBaseLine.updateQuality();
        app.updateQuality();

        for (int i = 0; i < items.length; i++) {
            assertThat(app.items[i].name, is(appBaseLine.items[i].name));
            assertThat(app.items[i].quality, is(appBaseLine.items[i].quality));
            assertThat(app.items[i].sellIn, is(appBaseLine.items[i].sellIn));
        }
    }

}
