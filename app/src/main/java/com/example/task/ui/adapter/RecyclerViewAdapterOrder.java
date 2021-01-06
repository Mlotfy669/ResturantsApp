package com.example.task.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task.R;
import com.example.task.db.model.Resturant.Order.Order;

import java.util.ArrayList;

public class RecyclerViewAdapterOrder extends RecyclerView.Adapter<RecyclerViewAdapterOrder.OrderAdapter> {

    private RecyclerView.RecycledViewPool viewPool= new RecyclerView.RecycledViewPool();
    private Context context;
    ArrayList<Order> ordersArrayList = new ArrayList<>();

    public ClickListnerInterfaceOrder orInterface;

    public RecyclerViewAdapterOrder(Context context, ClickListnerInterfaceOrder orInterface) {
        this.context = context;
        this.orInterface = orInterface;
    }

    public void setDataToAdapter(ArrayList<Order> arrayListOrder){

        this.ordersArrayList=arrayListOrder;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public OrderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_order,parent,false);
        return new OrderAdapter(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter holder, int position) {

        holder.getRestName().setText("Resturant: "+ordersArrayList.get(position).getResturant_name());
        holder.getOrderPrice().setText(("Price: "+ordersArrayList.get(position).getOrder_price()+" $").toString());
        holder.getOrderId().setText("Id: "+ordersArrayList.get(position).getOrder_id());
        holder.getOrderUser().setText("User: "+ordersArrayList.get(position).getOrder_user());


        LinearLayoutManager layoutManager= new LinearLayoutManager(holder.ChildRecyclerView.getContext()
                ,LinearLayoutManager.VERTICAL,false);
        layoutManager.setInitialPrefetchItemCount(ordersArrayList.get(position).getDetails().size());
        RecyclerViewAdapterOrderChild childItemAdapter= new RecyclerViewAdapterOrderChild(ordersArrayList.get(position).getDetails(),context);
        holder.ChildRecyclerView.setLayoutManager(layoutManager);
        holder.ChildRecyclerView.setAdapter(childItemAdapter);
        holder.ChildRecyclerView.setRecycledViewPool(viewPool);

        holder.linearLayout.setVisibility(View.GONE);
        holder.imageView.setImageResource(R.drawable.ic_arrow_down);
    }

    @Override
    public int getItemCount() {
        return  ordersArrayList!= null ? ordersArrayList.size() : 0;
    }

    class OrderAdapter extends RecyclerView.ViewHolder{

       TextView txt_rest_name,txt_order_price,txt_order_id,txt_order_user;
         RecyclerView ChildRecyclerView;
        LinearLayout linearLayout;
        ImageView imageView;

        public OrderAdapter(@NonNull View itemView) {
            super(itemView);
            ChildRecyclerView=itemView.findViewById(R.id.recyclerViewChild);
            linearLayout=itemView.findViewById(R.id.linearRecycler);
            imageView=itemView.findViewById(R.id.img_arrow);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    orInterface.onItemClick(linearLayout,imageView);
                }
            });
        }

        public TextView getRestName(){
            if(txt_rest_name==null){
                txt_rest_name=itemView.findViewById(R.id.rest_name);
            }
            return txt_rest_name;
        }
        public TextView getOrderPrice(){
            if(txt_order_price==null){
                txt_order_price=itemView.findViewById(R.id.order_price);
            }
            return txt_order_price;
        }
        public TextView getOrderId(){
            if(txt_order_id==null){
                txt_order_id=itemView.findViewById(R.id.order_id);
            }
            return txt_order_id;
        }
        public TextView getOrderUser(){
            if(txt_order_user==null){
                txt_order_user=itemView.findViewById(R.id.order_user);
            }
            return txt_order_user;
        }

    }
}
