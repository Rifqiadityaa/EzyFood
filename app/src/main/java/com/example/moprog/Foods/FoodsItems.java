package com.example.moprog.Foods;

public class FoodsItems {
    private int mFoodImageResource;
    private String mFoodName;
    private String mFoodPrice;

    public FoodsItems(int foodImageResource, String foodName, String foodPrice){
        mFoodImageResource = foodImageResource;
        mFoodName = foodName;
        mFoodPrice = foodPrice;
    }

    public int getImageResource(){
        return mFoodImageResource;
    }

    public String getText1(){
        return mFoodName;
    }

    public String getText2(){
        return mFoodPrice;
    }
}