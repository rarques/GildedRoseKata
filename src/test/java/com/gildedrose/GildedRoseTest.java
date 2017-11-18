package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    private GildedRose gildedRose;

    @Test
    public void test_itemWithDummyData_theNameOfTheCreatedItem() {
        Item[] items = new Item[]{new Item("nameOfTheItem", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("nameOfTheItem", app.items[0].name);
    }

    @Test
    public void commonItemDecreasesQuialityByOne() {
        Item[] items = new Item[]{
                new Item("CommonItem", 5, 10)
        };
        GildedRose sut = new GildedRose(items);

        sut.updateQuality();

        Item updatedItem = sut.items[0];
        assertThat(updatedItem.name, is("CommonItem"));
        assertThat(updatedItem.quality, is(9));
        assertThat(updatedItem.sellIn, is(4));
    }

}
