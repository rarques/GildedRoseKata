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

        GildedRoseBaseLine app = new GildedRoseBaseLine(baseLineItems);
        GildedRose refactoredApp = new GildedRose(items);

        app.updateQuality();
        refactoredApp.updateQuality();

        for (int itemIndex = 0; itemIndex < items.length; itemIndex++) {
            assertThat(refactoredApp.items[itemIndex].name, is(app.items[itemIndex].name));
            assertThat(refactoredApp.items[itemIndex].quality, is(app.items[itemIndex].quality));
            assertThat(refactoredApp.items[itemIndex].sellIn, is(app.items[itemIndex].sellIn));
        }
    }

}
