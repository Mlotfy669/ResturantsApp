package com.example.task.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task.R;
import com.example.task.db.model.Resturant.Restaurants;

import java.util.ArrayList;


public class RecyclerViewAdapterRest extends RecyclerView.Adapter<RecyclerViewAdapterRest.RestrantAdapter> {

    private Context context;
    ArrayList<Restaurants> restaurantsArrayList = new ArrayList<>();
    public ClickListnerInterfaceRest anInterface;

    public RecyclerViewAdapterRest(Context context, ClickListnerInterfaceRest anInterface) {
       this.context=context;
       this.anInterface=anInterface;
    }

    public void setDataToAdapter(ArrayList<Restaurants> arrayListRest){

        this.restaurantsArrayList=arrayListRest;
        notifyDataSetChanged();

    }

    @Override
    public RestrantAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_rest,parent,false);

        return new RestrantAdapter(v);
    }


        @Override
        public void onBindViewHolder(RestrantAdapter holder, int position) {

        holder.getFoodItem().setText(restaurantsArrayList.get(position).getRest_name());
        holder.getFoodId().setText(restaurantsArrayList.get(position).getRest_id());
        holder.getFoodType().setText(restaurantsArrayList.get(position).getRest_type());
        holder.getItemNumber().setText((restaurantsArrayList.get(position).getProducts().size()+" Item").toString());
        Glide.with(context).load(restaurantsArrayList.get(position).getRest_img()).into(holder.getImageView());

        holder.id= Integer.parseInt(restaurantsArrayList.get(position).getRest_id());

    }

    @Override
    public int getItemCount() {
        return  restaurantsArrayList!= null ? restaurantsArrayList.size() : 0;
    }

    class RestrantAdapter extends RecyclerView.ViewHolder{

        TextView txt_food_item,txt_number_of_item,txt_food_id,txt_food_type;
        ImageView img_food;
        int id;

        public RestrantAdapter(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    anInterface.onItemClick(id);
                }
            });
        }

        public TextView getFoodId(){
            if(txt_food_id==null){
                txt_food_id=itemView.findViewById(R.id.food_id);
            }
            return txt_food_id;
        }
        public TextView getFoodType(){
            if(txt_food_type==null){
                txt_food_type=itemView.findViewById(R.id.food_type);
            }
            return txt_food_type;
        }


        public TextView getFoodItem(){
            if(txt_food_item==null){
                txt_food_item=itemView.findViewById(R.id.food_item);
            }
            return txt_food_item;
        }

        public TextView getItemNumber(){
            if(txt_number_of_item==null){
                txt_number_of_item=itemView.findViewById(R.id.number_ofitem);
            }
            return txt_number_of_item;
        }

        public ImageView getImageView(){
            if(img_food==null){
                img_food=itemView.findViewById(R.id.img_food);
            }
            return img_food;
        }

    }



}
