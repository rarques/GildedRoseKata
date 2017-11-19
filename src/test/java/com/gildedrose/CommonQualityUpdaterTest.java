package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommonQualityUpdaterTest {

    @Test
    public void itemInSellingPeriodDecreasesOneQuality() {
        Item item = new Item("CommonItem", 10, 10);
        CommonQualityUpdater sut = new CommonQualityUpdater(item);

        sut.updateQuality();

        assertThat(item.quality, is(9));
    }

    @Test
    public void qualityCantBeNegative() {
        Item item = new Item("LowQualityItem", 10, 0);
        CommonQualityUpdater sut = new CommonQualityUpdater(item);

        sut.updateQuality();

        assertThat(item.quality, is(0));
    }

}