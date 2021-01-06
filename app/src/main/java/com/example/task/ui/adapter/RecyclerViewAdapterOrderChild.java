package com.example.task.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task.R;

import com.example.task.db.model.Resturant.Order.OrderDetails;

import java.util.ArrayList;

public class RecyclerViewAdapterOrderChild extends RecyclerView.Adapter<RecyclerViewAdapterOrderChild.OrderAdapterChild> {

    ArrayList<OrderDetails> ordersArraydetilies = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapterOrderChild(ArrayList<OrderDetails> ordersArraydetilies,Context context) {
        this.ordersArraydetilies = ordersArraydetilies;
        this.context=context;
    }

    public void setDataToAdapter(ArrayList<OrderDetails> arrayListOrder){

        this.ordersArraydetilies=arrayListOrder;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public OrderAdapterChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_order_child,parent,false);
        return new OrderAdapterChild(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapterChild holder, int position) {

        holder.getProdName().setText("Prod Name: "+ordersArraydetilies.get(position).getProd_name());
        holder.getProdPrice().setText("Prod Price: "+ordersArraydetilies.get(position).getProd_price());
        holder.getProdQuantity().setText("Prod Quantity: "+ordersArraydetilies.get(position).getProd_quantity());
        Glide.with(context).load(ordersArraydetilies.get(position).getProd_image()).into(holder.getProdImage());

    }

    @Override
    public int getItemCount() {
        return  ordersArraydetilies!= null ? ordersArraydetilies.size() : 0;
    }

    class OrderAdapterChild extends RecyclerView.ViewHolder{

        TextView txt_prod_name,txt_prod_quantity,txt_prod_price;
        ImageView prod_img;

        public OrderAdapterChild(@NonNull View itemView) {
            super(itemView);
        }

        public TextView getProdName(){
            if(txt_prod_name==null){
                txt_prod_name=itemView.findViewById(R.id.prod_name);
            }
            return txt_prod_name;
        }
        public TextView getProdQuantity(){
            if(txt_prod_quantity==null){
                txt_prod_quantity=itemView.findViewById(R.id.prod_quantity);
            }
            return txt_prod_quantity;
        }
        public TextView getProdPrice(){
            if(txt_prod_price==null){
                txt_prod_price=itemView.findViewById(R.id.prod_price);
            }
            return txt_prod_price;
        }
        public ImageView getProdImage(){
            if(prod_img==null){
                prod_img=itemView.findViewById(R.id.prod_img);
            }
            return prod_img;
        }
    }
}
