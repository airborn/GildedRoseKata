package pl.airborn.quality;

import pl.airborn.Item;

import java.util.HashMap;
import java.util.Map;

public class QualityStrategyFactory {
    private final Map<String, QualityStrategy> customQualityStrategies = new HashMap<>();
    private final QualityStrategy defaultQualityStrategy = new DefaultQualityStrategy();

    public QualityStrategyFactory() {
        customQualityStrategies.put("Sulfuras, Hand of Ragnaros", new LegendaryItemQualityStrategy());
        customQualityStrategies.put("Aged Brie", new BrieQualityStrategy());
        customQualityStrategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassQualityStrategy());
        customQualityStrategies.put("Conjured cloak", new ConjuredQualityStrategy());
    }

    public QualityStrategy selectAgingStrategy(Item item) {
        return customQualityStrategies.getOrDefault(item.getName(), defaultQualityStrategy);
    }
}
