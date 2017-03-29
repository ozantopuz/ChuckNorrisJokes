package com.foreks.chucknorrisjokes.models;

/**
 * Created by ozan on 29/03/17.
 */

public class CategoriesResponse {

    private String categories;

    public CategoriesResponse(String categories) {
        this.categories = categories;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
