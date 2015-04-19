package com.ucr2go.return0.ucr2go.Model;

/**
 * Created by daniel on 4/19/15.
 */
public class Node {
    private Integer mDrawableId;
    private Double mPrice;
    private String mName;

    public Node(String name, double price, int drawableId){
        mName = name;
        mPrice = price;
        mDrawableId = drawableId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public int getDrawableId() {
        return mDrawableId;
    }

    public void setDrawableId(int drawableId) {
        mDrawableId = drawableId;
    }


}
