package com.example.task.ui.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.task.R;
import com.example.task.db.model.Resturant.Login.LoginData;
import com.example.task.db.model.Resturant.Login.LoginResponse;
import com.example.task.ui.viewmodel.LoginViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText editTextPhone, editTextPassword;
    Button btnLogin;
    LoginViewModel viewModel;
    private static final String TAG="LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel= ViewModelProviders.of(this,new LoginViewModelFactory(LoginActivity.this))
                .get(LoginViewModel.class);

        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTextPhone.getText().toString().isEmpty()){
                    editTextPhone.setError("please enter the phone number");
                    return;
                }
                if(editTextPhone.getText().toString().length()<10){
                    editTextPhone.setError("please enter correct phone number");
                    return;
                }
                if(editTextPassword.getText().toString().isEmpty()){
                    editTextPassword.setError("please enter the password");
                    return;
                }
                if (editTextPhone.getText().toString() != null && editTextPassword.getText().toString() != null) {

                    viewModel.set_loginData(new LoginData(editTextPhone.getText().toString().trim(), editTextPassword.getText().toString().trim()));
                    viewModel.getLoginResponseLiveData().observe(LoginActivity.this,new Observer<LoginResponse>(){
                        @Override
                        public void onChanged(LoginResponse loginResponse) {
                            if(loginResponse!=null){
                                if(loginResponse.getMessage()!=null){
                                    Log.d(TAG, "onChanged: getMessage "+loginResponse.getMessage());
                                }
                                if (loginResponse.getSubMessage()!=null && loginResponse.getSubMessage().equals("success")){

                                    Log.d(TAG, "onChanged: getSubMessage "+loginResponse.getSubMessage());
                                    Intent i=new Intent(LoginActivity.this, ResturantActivity.class);
                                    startActivity(i);
                                }
                                if (loginResponse.getStatus()!=null){
                                    Log.d(TAG, "onChanged: getStatus "+loginResponse.getStatus());
                                }
                            }else{
                                //show somthing to the user
                                Log.d(TAG, "onChanged: login response = null ");
                            }
                        }
                    });
                }
            }
        });
    }

    class LoginViewModelFactory implements ViewModelProvider.Factory{

        private LoginActivity activity;

        public LoginViewModelFactory(LoginActivity activity) {
            this.activity = activity;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new LoginViewModel (activity) ;
        }
    }
}