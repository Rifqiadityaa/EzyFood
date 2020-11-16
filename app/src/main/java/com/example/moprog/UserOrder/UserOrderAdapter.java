package com.example.moprog.UserOrder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.moprog.R;

import java.util.ArrayList;

public class UserOrderAdapter extends RecyclerView.Adapter<UserOrderAdapter.UserOrderViewHolder>{
    private ArrayList<UserOrderItems> mUserOrderItemsList;
    private UserOrderAdapter.onItemClickListener mListener;

    public interface onItemClickListener{
        void onItemClick(int pos);
        void onRemoveClick(int pos);
    }

    public void setOnItemClickListener(UserOrderAdapter.onItemClickListener listener){
        mListener = listener;
    }

    public static class UserOrderViewHolder extends RecyclerView.ViewHolder{
        public ImageView userOrderImageView;
        public TextView userOrderName;
        public TextView userOrderPrice;
        public ImageView mRemoveImage;

        public UserOrderViewHolder(View itemView, final UserOrderAdapter.onItemClickListener listener) {
            super(itemView);
            userOrderImageView = itemView.findViewById(R.id.userOrderImageView);
            userOrderName = itemView.findViewById(R.id.userOrderName);
            userOrderPrice = itemView.findViewById(R.id.userOrderPrice);

            mRemoveImage = itemView.findViewById(R.id.userOrderRemoveImg);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            listener.onItemClick(pos);
                        }
                    }
                }
            });

            mRemoveImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            listener.onRemoveClick(pos);
                        }
                    }
                }
            });
        }
    }

    public UserOrderAdapter(ArrayList<UserOrderItems> userOrderItemsList){
        mUserOrderItemsList = userOrderItemsList;
    }

    @Override
    public UserOrderAdapter.UserOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_order_items, parent, false);
        UserOrderAdapter.UserOrderViewHolder uovh = new UserOrderAdapter.UserOrderViewHolder(v, mListener);
        return uovh;
    }

    @Override
    public void onBindViewHolder(UserOrderAdapter.UserOrderViewHolder holder, int position) {
        UserOrderItems currentItems = mUserOrderItemsList.get(position);

        holder.userOrderImageView.setImageResource(currentItems.getUserOrderImageResource());
        holder.userOrderName.setText(currentItems.getUserOrderName());
        holder.userOrderPrice.setText(currentItems.getUserOrdersPrice());
    }

    @Override
    public int getItemCount() {
        return mUserOrderItemsList.size();
    }
}
