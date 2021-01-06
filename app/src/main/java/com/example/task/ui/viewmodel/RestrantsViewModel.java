package com.example.task.ui.viewmodel;

import android.app.Activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.task.db.model.Resturant.Restaurants;
import com.example.task.repository.Repositery;
import com.example.task.ui.activites.ResturantActivity;

import java.util.ArrayList;

public class RestrantsViewModel extends ViewModel {

    private LiveData<ArrayList<Restaurants>> liveData;
    private Repositery repositery;
    private static ResturantActivity resturantActivity;


    public RestrantsViewModel(Activity activity) {
        repositery=new Repositery();
        resturantActivity = (ResturantActivity) activity;
    }


    public LiveData<ArrayList<Restaurants>> getManyResturant(){
        liveData=repositery.getManyRest();
        return liveData;
    }

    public static void errorMessage(String error){
        resturantActivity.errorMessage(error);
    }




}
