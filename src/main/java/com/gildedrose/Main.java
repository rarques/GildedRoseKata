package com.gildedrose;

/**
 * La classe internacionalitzada és la classe GildedRose
 *
 * @author rav3 ; rav3@alumnes.udl.cat
 * @see GildedRose
 */
public class Main {

    public static void main(String[] args) {

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
    }

}
