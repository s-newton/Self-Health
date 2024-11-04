package com.zybooks.graph;

import java.util.Date;

public class WeightData {

    private Date mDateid;
    private int mWeight;

    public WeightData() {}

    public WeightData(Date date, int weight){
        mDateid = date;
        mWeight = weight;
    }

    public Date getDateid() {
        return mDateid;
    }
    public void setDateid(Date date){
        this.mDateid = date;
    }
    public int getWeight(){
        return mWeight;
    }
    public void setWeight(int weight){
        this.mWeight = weight;
    }

}
