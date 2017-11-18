package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class QualityUpdaterTest {

    @Test
    public void test_classifyCommonItem_CommonUpdater() throws Exception {
        Item item = new Item("CommonItem", 10, 10);

        QualityUpdater sut = QualityUpdater.classify(item);

        assertThat(sut, is(instanceOf(CommonQualityUpdater.class)));
    }

    @Test
    public void test_classifyAgedBrie_AgedBrieUpdater() throws Exception {
        Item item = new Item(QualityUpdater.AGED_BRIE, 10, 10);

        QualityUpdater sut = QualityUpdater.classify(item);

        assertThat(sut, is(instanceOf(AgedBrieQualityUpdater.class)));
    }

}