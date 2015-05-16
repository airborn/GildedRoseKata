package pl.airborn.quality;

import pl.airborn.Item;

class DefaultQualityStrategy extends QualityStrategy {

    @Override
    public void modifyQuality(Item item) {
        decreaseQuality(item);
        if (item.getSellIn() < 0) {
            decreaseQuality(item);
        }
    }

}
