package com.zybooks.graph;

import android.content.Context;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
import java.util.Date;
import  java.util.List;
@Database(entities = {WeightData.class},version = 2)
public abstract class WeightDataRepo extends RoomDatabase {

    public abstract WeightDataDAO getWeightDataDAO();

}

