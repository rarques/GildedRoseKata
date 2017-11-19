package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.QualityUpdater.MAGIC_ITEM;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MagicItemQualityUpdaterTest {

    @Test
    public void qualityDecreasesByTwo() throws Exception {
        Item item = new Item(MAGIC_ITEM, 10, 10);
        MagicItemQualityUpdater sut = new MagicItemQualityUpdater(item);

        sut.update();

        assertThat(item.quality, is(8));
    }

}