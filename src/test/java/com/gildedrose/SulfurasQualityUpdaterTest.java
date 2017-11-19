package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.QualityUpdater.LEGENDARY_QUALITY;
import static com.gildedrose.QualityUpdater.SULFURAS_HAND_OF_RAGNAROS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SulfurasQualityUpdaterTest {

    @Test
    public void qualityDoesntDecrease() throws Exception {
        Item item = new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 80);
        SulfurasQualityUpdater sut = new SulfurasQualityUpdater(item);

        sut.updateQuality();

        assertThat(item.quality, is(LEGENDARY_QUALITY));
    }

    @Test
    public void sellInDoesntDecrease() throws Exception {
        Item item = new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 80);
        SulfurasQualityUpdater sut = new SulfurasQualityUpdater(item);

        sut.update();

        assertThat(item.sellIn, is(10));
    }

}