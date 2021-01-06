package com.example.task.ui.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.task.R;
import com.example.task.db.model.Resturant.Restaurants;
import com.example.task.ui.adapter.ClickListnerInterfaceRest;
import com.example.task.ui.adapter.RecyclerViewAdapterRest;
import com.example.task.ui.viewmodel.RestrantsViewModel;

import java.util.ArrayList;

public class ResturantActivity extends AppCompatActivity {

    RecyclerViewAdapterRest recyclerViewAdapterRest;
    RecyclerView rv;
    ProgressBar  progressBar;
    RestrantsViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        init();
        getData();
    }

    public void init(){
        progressBar=findViewById(R.id.progBar);

        rv=findViewById(R.id.recyclerView);
        recyclerViewAdapterRest =new RecyclerViewAdapterRest(this, new ClickListnerInterfaceRest() {
            @Override
            public void onItemClick(int id) {
                Intent i=new Intent(ResturantActivity.this,OrderActivity.class);
                i.putExtra("restId", (id-1));
                startActivity(i);
            }
        });
        rv.setAdapter(recyclerViewAdapterRest);

        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setHasFixedSize(true);

        viewModel= ViewModelProviders.of(this,new ResturantViewModelFactory(ResturantActivity.this))
                .get(RestrantsViewModel.class);
    }

    public void getData(){
        viewModel.getManyResturant().observe(this, new Observer<ArrayList<Restaurants>>() {
            @Override
            public void onChanged(ArrayList<Restaurants> restaurants) {
                if(restaurants!= null){
                    progressBar.setVisibility(View.GONE);
                    fillData(restaurants);
                }
            }
        });


    }

    private void fillData(ArrayList<Restaurants> restaurants) {
        recyclerViewAdapterRest.setDataToAdapter(restaurants);
    }

    public void errorMessage(String error){
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    class ResturantViewModelFactory implements ViewModelProvider.Factory{

        private ResturantActivity activity;

       public ResturantViewModelFactory(ResturantActivity activity) {
           this.activity = activity;
       }

       @NonNull
       @Override
       public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
           return (T) new RestrantsViewModel (activity) ;
       }
   }
}