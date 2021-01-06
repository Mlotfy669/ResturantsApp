package com.example.task.ui.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.task.R;
import com.example.task.db.model.Resturant.Order.Order;
import com.example.task.ui.adapter.ClickListnerInterfaceOrder;
import com.example.task.ui.adapter.RecyclerViewAdapterOrder;
import com.example.task.ui.viewmodel.OrderViewModel;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    OrderViewModel orderViewModel;
    RecyclerViewAdapterOrder viewAdapterOrder;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    int restId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        progressBar=findViewById(R.id.progBarOrder);
        init();
        getData();
    }


    public void init(){
        restId = getIntent().getExtras().getInt("restId");
        recyclerView=findViewById(R.id.recyclerViewOrder);
        viewAdapterOrder=new RecyclerViewAdapterOrder(this, new ClickListnerInterfaceOrder() {
            @Override
            public void onItemClick(LinearLayout linearLayout, ImageView imageView) {

                if(linearLayout.getVisibility()==View.GONE){
                    linearLayout.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.drawable.ic_arrow_up);

                }else{
                    linearLayout.setVisibility(View.GONE);
                    imageView.setImageResource(R.drawable.ic_arrow_down);

                }
            }
        });
        recyclerView.setAdapter(viewAdapterOrder);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);

        orderViewModel= ViewModelProviders.of(this,new OrderActivity.OrderViewModelFactory(OrderActivity.this))
                .get(OrderViewModel.class);
    }

    public void getData(){
        orderViewModel.getManyOrder(restId).observe(this, new Observer<ArrayList<Order>>() {
            @Override
            public void onChanged(ArrayList<Order> orders) {
                if(orders!= null){
                    progressBar.setVisibility(View.GONE);
                    fillData(orders);
                }
            }
        });


    }

    private void fillData(ArrayList<Order> orders) {
        viewAdapterOrder.setDataToAdapter(orders);
    }



    class OrderViewModelFactory implements ViewModelProvider.Factory{

        private OrderActivity activity;

        public OrderViewModelFactory(OrderActivity activity) {
            this.activity = activity;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new OrderViewModel (activity) ;
        }
    }

    public void errorMessage(String error){
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}