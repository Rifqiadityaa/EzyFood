package com.example.moprog.UserOrder;

public class UserOrderItems {
    private int mUserOrderImageResource;
    private String mUserOrderName;
    private String mUserOrderPrice;

    public UserOrderItems(int userOrderImageResource, String userOrderName, String userOrderPrice){
        mUserOrderImageResource = userOrderImageResource;
        mUserOrderName = userOrderName;
        mUserOrderPrice= userOrderPrice;
    }

    public int getUserOrderImageResource(){
        return mUserOrderImageResource;
    }

    public String getUserOrderName(){ return mUserOrderName; }

    public String getUserOrdersPrice(){ return mUserOrderPrice; }
}
