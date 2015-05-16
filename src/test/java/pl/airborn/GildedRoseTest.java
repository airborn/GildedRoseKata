package pl.airborn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


public class GildedRoseTest {

    @Test
    public void shouldRemainOriginalBehaviour() throws Exception {
        List<Item> items = itemList();
        List<Item> origItems = itemList();

        GildedRose gildedRose = new GildedRose(items);
        OriginalGildedRose originalGildedRose = new OriginalGildedRose(origItems);

        for (int i = 0; i < 20; i++) {
            gildedRose.updateQuality();
            originalGildedRose.updateQuality();
            List<Item> newItems = gildedRose.getItems();
            List<Item> originalItems = originalGildedRose.getItems();
            assertThat(newItems).containsExactlyElementsOf(originalItems);
        }
    }

    @Test
    public void shouldDegradeConjuredItemsTwiceAsFast() throws Exception {
        List<Item> items = Arrays.asList(
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Conjured cloak", 10, 20)
        );

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        assertThat(items.get(0).getQuality()).isEqualTo(19);
        assertThat(items.get(1).getQuality()).isEqualTo(18);
    }

    private List<Item> itemList() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        return items;
    }
}