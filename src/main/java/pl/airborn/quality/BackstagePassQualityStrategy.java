package pl.airborn.quality;

import pl.airborn.Item;

class BackstagePassQualityStrategy extends QualityStrategy {

    @Override
    public void modifyQuality(Item item) {
        increaseQuality(item);
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
    }
}
