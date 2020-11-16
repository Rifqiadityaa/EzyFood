package com.example.moprog.Drinks;

public class DrinksItems {
    private int mDrinksImageResource;
    private String mDrinksName;
    private String mDrinksPrice;

    public DrinksItems(int drinksImageResource, String drinksName, String drinksPrice){
        mDrinksImageResource = drinksImageResource;
        mDrinksName = drinksName;
        mDrinksPrice= drinksPrice;
    }

    public int getDrinksImageResource(){
        return mDrinksImageResource;
    }

    public String getDrinksName(){ return mDrinksName; }

    public String getDrinksPrice(){ return mDrinksPrice; }
}
