package com.solvd.testautomation.ui.components;

public enum Menu {
    SHOES("Shoes"),
    CLOTHING("Clothing"),
    ACCESSORIES("Accessories"),
    SALE("Sale");

    public String getOptionName() {
        return optionName;
    }
    private String optionName;
    Menu(String option) {
        this.optionName = option;
    }
}
