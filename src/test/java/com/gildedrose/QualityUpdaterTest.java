package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.QualityUpdater.AGED_BRIE;
import static com.gildedrose.QualityUpdater.BACKSTAGE_PASSES;
import static com.gildedrose.QualityUpdater.SULFURAS_HAND_OF_RAGNAROS;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QualityUpdaterTest {

    @Test
    public void test_classifyCommonItem_CommonUpdater() throws Exception {
        Item item = new Item("CommonItem", 10, 10);

        QualityUpdater sut = QualityUpdater.classify(item);

        assertThat(sut, is(instanceOf(CommonQualityUpdater.class)));
    }

    @Test
    public void test_classifyAgedBrie_AgedBrieUpdater() throws Exception {
        Item item = new Item(AGED_BRIE, 10, 10);

        QualityUpdater sut = QualityUpdater.classify(item);

        assertThat(sut, is(instanceOf(AgedBrieQualityUpdater.class)));
    }

    @Test
    public void test_classifySulfuras_SulfurasQualityUpdater() throws Exception {
        Item item = new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 10);

        QualityUpdater sut = QualityUpdater.classify(item);

        assertThat(sut, is(instanceOf(SulfurasQualityUpdater.class)));
    }

    @Test
    public void test_classifyBackstagePass_BackstagePassesQualityUpdater() throws Exception {
        Item item = new Item(BACKSTAGE_PASSES, 10, 10);

        QualityUpdater sut = QualityUpdater.classify(item);

        assertThat(sut, is(instanceOf(BackstagePassesQualityUpdater.class)));
    }

}