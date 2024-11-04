package com.zybooks.graph;

import android.content.Context;
import java.util.ArrayList;
import java.util.Date;
import  java.util.List;

public class WeightDataRepo {
    private static WeightDataRepo instance;
    private List<WeightData> mWeightData;
    
    public static WeightDataRepo getInstance(Context context){
        if(instance == null){
            instance = new WeightDataRepo(context);
        }
        return instance;
    }

    private WeightDataRepo(Context context){
        mWeightData = new ArrayList<>();
    }
    public List<WeightData> getAllweightdata(){
        return mWeightData;
    }
    public WeightData getWeightdata(Date date){
        for(WeightData data : mWeightData){
            if(data.getDateid() == date){
                return data;
            }
        }
        return null;
    }
    public void addWeightData(WeightData weightData){
        mWeightData.add(weightData);
    }
}
