package pl.airborn;

import pl.airborn.aging.AgingStrategy;
import pl.airborn.aging.AgingStrategyFactory;

import java.util.List;

public class GildedRose {

    private List<Item> items;
    private AgingStrategyFactory agingStrategyFactory = new AgingStrategyFactory();

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            AgingStrategy agingStrategy = agingStrategyFactory.selectAgingStrategy(item);
            agingStrategy.makeOlder(item);

            if (item.getName().equals("Aged Brie") || item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQuality(item);
                if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.getSellIn() < 0) {
                        item.setQuality(0);
                    } else {
                        if (item.getSellIn() < 10) {
                            increaseQuality(item);
                        }

                        if (item.getSellIn() < 5) {
                            increaseQuality(item);
                        }
                    }
                } else if(item.getName().equals("Aged Brie")){
                    if (item.getSellIn() < 0) {
                        increaseQuality(item);
                    }
                }
            } else {
                decreaseQuality(item);
                if (item.getSellIn() < 0) {
                    decreaseQuality(item);
                }
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                item.setQuality(item.getQuality() - 1);
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }
}