package pl.airborn.quality;

import pl.airborn.Item;

class BrieQualityStrategy extends QualityStrategy {

    @Override
    public void modifyQuality(Item item) {
        increaseQuality(item);
        if (item.getSellIn() < 0) {
            increaseQuality(item);
        }
    }
}
