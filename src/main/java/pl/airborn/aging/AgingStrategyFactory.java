package pl.airborn.aging;

import pl.airborn.Item;

import java.util.HashMap;
import java.util.Map;

public class AgingStrategyFactory {

    private final Map<String, AgingStrategy> customAgingStrategies = new HashMap<>();
    private final AgingStrategy defaultAgingAgingStrategy = new DefaultAgingAgingStrategy();

    public AgingStrategyFactory() {
        customAgingStrategies.put("Sulfuras, Hand of Ragnaros", new LegendaryItemAgingStrategy());
    }

    public AgingStrategy selectAgingStrategy(Item item) {
        return customAgingStrategies.getOrDefault(item.getName(), defaultAgingAgingStrategy);
    }
}
