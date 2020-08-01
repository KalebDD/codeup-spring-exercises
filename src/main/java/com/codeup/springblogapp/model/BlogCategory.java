package com.codeup.springblogapp.model;

public enum BlogCategory {

    COOKING ("COOKING"),
    HOWTO ("HOW TO"),
    INSPIRATION ("INSPIRATION"),
    OTHER ("OTHER");

    private final String categoryValue;

    private BlogCategory (String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getCategoryValue() {
        return categoryValue;
    }
}
