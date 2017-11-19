package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.QualityUpdater.MAX_QUAILITY;
import static com.gildedrose.QualityUpdater.SULFURAS_HAND_OF_RAGNAROS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SulfurasQualityUpdaterTest {

    @Test
    public void qualityDoesntDecrease() throws Exception {
        Item item = new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 50);
        SulfurasQualityUpdater sut = new SulfurasQualityUpdater(item);

        sut.updateQuality();

        assertThat(item.quality, is(MAX_QUAILITY));
    }

    @Test
    public void sellInDoesntDecrease() throws Exception {
        Item item = new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 50);
        SulfurasQualityUpdater sut = new SulfurasQualityUpdater(item);

        sut.updateQuality();

        assertThat(item.sellIn, is(10));
    }

}