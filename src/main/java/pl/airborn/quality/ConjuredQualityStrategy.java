package pl.airborn.quality;

import pl.airborn.Item;

class ConjuredQualityStrategy extends DefaultQualityStrategy {

    @Override
    public void modifyQuality(Item item) {
        super.modifyQuality(item);
        super.modifyQuality(item);
    }
}
