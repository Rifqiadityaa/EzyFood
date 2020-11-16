package com.example.moprog.Foods;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.moprog.R;

import java.util.ArrayList;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.FoodsViewHolder>{
    private ArrayList<FoodsItems> mFoodsItemsList;
    private FoodsAdapter.onItemClickListener mListener;

    public interface onItemClickListener{
        void onItemClick(int p);
    }

    public void setOnItemClickListener(FoodsAdapter.onItemClickListener listener){
        mListener = listener;
    }

    public static class FoodsViewHolder extends RecyclerView.ViewHolder{
        public ImageView foodsImageView;
        public TextView foodsName;
        public TextView foodsPrice;

        public FoodsViewHolder(View itemView, final FoodsAdapter.onItemClickListener listener) {
            super(itemView);
            foodsImageView = itemView.findViewById(R.id.foodsImageView);
            foodsName = itemView.findViewById(R.id.foodsName);
            foodsPrice = itemView.findViewById(R.id.foodsPrice);

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
        }
    }

    public FoodsAdapter(ArrayList<FoodsItems> foodsItemsList){
        mFoodsItemsList = foodsItemsList;
    }

    @Override
    public FoodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.foods_items, parent, false);
        FoodsViewHolder fvh = new FoodsViewHolder(v, mListener);
        return fvh;
    }

    @Override
    public void onBindViewHolder(FoodsViewHolder holder, int position) {
        FoodsItems currentItems = mFoodsItemsList.get(position);

        holder.foodsImageView.setImageResource(currentItems.getImageResource());
        holder.foodsName.setText(currentItems.getText1());
        holder.foodsPrice.setText(currentItems.getText2());
    }

    @Override
    public int getItemCount() {
        return mFoodsItemsList.size();
    }
}
