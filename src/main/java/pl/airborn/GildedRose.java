package pl.airborn;

import pl.airborn.aging.AgingStrategy;
import pl.airborn.aging.AgingStrategyFactory;
import pl.airborn.quality.QualityStrategy;
import pl.airborn.quality.QualityStrategyFactory;

import java.util.List;

public class GildedRose {

    private List<Item> items;
    private AgingStrategyFactory agingStrategyFactory = new AgingStrategyFactory();
    private QualityStrategyFactory qualityStrategyFactory = new QualityStrategyFactory();

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            AgingStrategy agingStrategy = agingStrategyFactory.selectAgingStrategy(item);
            agingStrategy.makeOlder(item);

            QualityStrategy qualityStrategy = qualityStrategyFactory.selectAgingStrategy(item);
            qualityStrategy.modifyQuality(item);
        }
    }

    public List<Item> getItems() {
        return items;
    }
}