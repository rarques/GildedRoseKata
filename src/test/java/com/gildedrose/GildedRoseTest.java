package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
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

}
