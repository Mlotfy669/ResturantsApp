package com.example.task.ui.viewmodel;

import android.app.Activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.task.db.model.Resturant.Login.LoginData;
import com.example.task.db.model.Resturant.Login.LoginResponse;
import com.example.task.repository.Repositery;
import com.example.task.ui.activites.LoginActivity;

public class LoginViewModel extends ViewModel {

    private Repositery repositery;
    private static LoginActivity loginActivity;

    public LoginViewModel(Activity activity){
        repositery=new Repositery();
        loginActivity = (LoginActivity) activity;
    }

    private MutableLiveData<LoginData> _loginData=new MutableLiveData<>();
    private LiveData<LoginResponse> loginResponseLiveData= Transformations.switchMap(_loginData, loginData->
            repositery.login(loginData));

    public void set_loginData(LoginData _loginData) {
        if (this._loginData.getValue()==_loginData)
            return;
        this._loginData.setValue(_loginData);
    }

    public LiveData<LoginResponse> getLoginResponseLiveData() {
        return loginResponseLiveData;
    }
}
