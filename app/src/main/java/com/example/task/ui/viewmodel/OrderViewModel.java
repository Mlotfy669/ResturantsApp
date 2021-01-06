package com.example.task.ui.viewmodel;

import android.app.Activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.task.db.model.Resturant.Order.Order;
import com.example.task.repository.Repositery;
import com.example.task.ui.activites.OrderActivity;

import java.util.ArrayList;

public class OrderViewModel extends ViewModel {

    private LiveData<ArrayList<Order>> liveData;
    private Repositery repositery;
    private static OrderActivity orderActivity;



    public OrderViewModel(Activity activity) {
        repositery=new Repositery();

        orderActivity= (OrderActivity) activity;
    }

    public LiveData<ArrayList<Order>> getManyOrder(int restId){
        liveData=repositery.getManyOrder(restId);
        return liveData;
    }

    public static void errorMessage(String error){
        orderActivity.errorMessage(error);
    }
}
