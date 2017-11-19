package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.QualityUpdater.AGED_BRIE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AgedBrieQualityUpdaterTest {

    @Test
    public void increasesQualityByOne() throws Exception {
        Item item = new Item(AGED_BRIE, 10, 10);
        AgedBrieQualityUpdater sut = new AgedBrieQualityUpdater(item);

        sut.updateQuality();

        assertThat(item.quality, is(11));
    }

    @Test
    public void brieOutOfSellingPeriodIncreasesQualityByTwo() throws Exception {
        Item item = new Item(AGED_BRIE, 0, 10);
        AgedBrieQualityUpdater sut = new AgedBrieQualityUpdater(item);

        sut.updateQuality();

        assertThat(item.quality, is(12));
    }

}