package com.luiz.domain.model;

public enum Category {

    ART("Discover coins, stamps, comics, and more"),
    FASHION("Clothing"),
    ELECTRONICS("Up to 50% off phones, TVs, and more"),
    ENTERTAINMENT("Movie props, posters, autographs and more"),
    HOME_AND_GARDEN("Keep the DIYers in your life crafting like crazy"),
    MOTORS("Car & Truck Parts"),
    SPORTING("Shop the gear you need for your outdoor activities, team sports, and workout routines"),
    TOYS("Whether it's rare, retro, or right-now, the perfect toy is here"),
    OTHERS("All the DIY essentials for your next project");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
