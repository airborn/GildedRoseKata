package pl.airborn.aging;

import pl.airborn.Item;

class DefaultAgingAgingStrategy implements AgingStrategy {

    @Override
    public void makeOlder(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }
}
