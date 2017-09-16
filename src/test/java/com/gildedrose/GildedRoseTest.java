package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    @Test
    public void test_itemWithDummyData_theNameOfTheCreatedItem() {
        Item[] items = new Item[]{new Item("nameOfTheItem", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("nameOfTheItem", app.items[0].name);
    }

    @Test
    public void testGildedRoseRefactoredAndGildedRoseBaseLineDoTheSamThing() {
        Item[] baseLineItems = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};

        GildedRoseBaseLine baseLine = new GildedRoseBaseLine(baseLineItems);
        GildedRose gildedRose = new GildedRose(items);

        baseLine.updateQuality();
        gildedRose.updateQuality();

        for (int itemIndex = 0; itemIndex < items.length; itemIndex++) {
            assertThat("Failing item: " + items[itemIndex].name, gildedRose.items[itemIndex].name, is(baseLine.items[itemIndex].name));
            assertThat("Failing item quality: " + items[itemIndex].name, gildedRose.items[itemIndex].quality, is(baseLine.items[itemIndex].quality));
            assertThat("Failing item sellIn: " + items[itemIndex].name, gildedRose.items[itemIndex].sellIn, is(baseLine.items[itemIndex].sellIn));
        }
    }

}
