package com.example.task.repository;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.task.db.ApiClient;
import com.example.task.db.dao.ApiInterfce;
import com.example.task.db.model.Resturant.Login.LoginData;
import com.example.task.db.model.Resturant.Login.LoginResponse;
import com.example.task.db.model.Resturant.Order.Order;
import com.example.task.db.model.Resturant.Order.RetJsonOrder;
import com.example.task.db.model.Resturant.Restaurants;
import com.example.task.db.model.Resturant.RetJSON;
import com.example.task.ui.viewmodel.RestrantsViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositery {

    private static final String TAG="Repository";
    private ApiInterfce apiInterfce;

    public Repositery() {
        apiInterfce= ApiClient.getClient().create(ApiInterfce.class);
    }

    public LiveData<ArrayList<Restaurants>> getManyRest(){

        final MutableLiveData<ArrayList<Restaurants>> mutableLiveData=new MutableLiveData<>();

        apiInterfce.getResturants().enqueue(new Callback<RetJSON>() {
            @Override
            public void onResponse(Call<RetJSON> call, Response<RetJSON> response) {
                if(response.isSuccessful()){
                    mutableLiveData.setValue(response.body().getReturn());
                }
                else{
                    //error
                    RestrantsViewModel.errorMessage("Something wrong");
                }
            }

            @Override
            public void onFailure(Call<RetJSON> call, Throwable t) {
                t.printStackTrace();
                //error
                RestrantsViewModel.errorMessage(t.getMessage());
            }
        });

        return mutableLiveData;
    }


    public LiveData<ArrayList<Order>> getManyOrder(int restId){

        final MutableLiveData<ArrayList<Order>> mutableLiveData=new MutableLiveData<>();
        apiInterfce.getOrder(restId, "ar").enqueue(new Callback<RetJsonOrder>() {
            @Override
            public void onResponse(Call<RetJsonOrder> call, Response<RetJsonOrder> response) {
                if(response.isSuccessful()){
                    mutableLiveData.setValue(response.body().getReturn());
                }
                else{
                    //error
                    RestrantsViewModel.errorMessage("Something wrong");
                }
            }

            @Override
            public void onFailure(Call<RetJsonOrder> call, Throwable t) {
                t.printStackTrace();
                //error
                RestrantsViewModel.errorMessage(t.getMessage());
            }
        });

        return mutableLiveData;
    }

    public LiveData<LoginResponse> login(LoginData loginData){
        final MutableLiveData<LoginResponse> mutableLiveData=new MutableLiveData<>();
        apiInterfce.postLogin(loginData).enqueue(new Callback<LoginResponse>(){
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                t.printStackTrace();
                Log.d(TAG, "onFailure: "+t.getMessage());
                Log.d(TAG, "onFailure: "+call.request().body());
                }
        });
        return mutableLiveData;
    }

}
