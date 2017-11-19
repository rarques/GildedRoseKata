package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.QualityUpdater.AGED_BRIE;
import static com.gildedrose.QualityUpdater.BACKSTAGE_PASSES;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BackstagePassesQualityUpdaterTest {

    @Test
    public void tenDaysForConcertIncreasesQualityByTwo() throws Exception {
        Item item = new Item(BACKSTAGE_PASSES, 10, 20);
        BackstagePassesQualityUpdater sut = new BackstagePassesQualityUpdater(item);

        sut.updateQuality();

        assertThat(item.quality, is(22));
    }

    @Test
    public void fiveDaysForConcertIncreasesQualityByThree() throws Exception {
        Item item = new Item(BACKSTAGE_PASSES, 5, 20);
        BackstagePassesQualityUpdater sut = new BackstagePassesQualityUpdater(item);

        sut.updateQuality();

        assertThat(item.quality, is(23));
    }

    @Test
    public void outOfSellingDateQualityFallsToZero() throws Exception {
        Item item = new Item(BACKSTAGE_PASSES, 0, 20);
        BackstagePassesQualityUpdater sut = new BackstagePassesQualityUpdater(item);

        sut.updateQuality();

        assertThat(item.quality, is(0));
    }

}