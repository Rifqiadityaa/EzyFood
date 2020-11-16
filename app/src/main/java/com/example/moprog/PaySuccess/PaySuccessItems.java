package com.example.moprog.PaySuccess;

public class PaySuccessItems {
    private int mPaySuccessImageResource;
    private String mPaySuccessName;
    private String mPaySuccessPrice;

    public PaySuccessItems(int paySuccessImageResource, String paySuccessName, String paySuccessPrice){
        mPaySuccessImageResource = paySuccessImageResource;
        mPaySuccessName = paySuccessName;
        mPaySuccessPrice= paySuccessPrice;
    }

    public int getPaySuccessImageResource(){
        return mPaySuccessImageResource;
    }

    public String getPaySuccessName(){ return mPaySuccessName; }

    public String getPaySuccessPrice(){ return mPaySuccessPrice; }
}
