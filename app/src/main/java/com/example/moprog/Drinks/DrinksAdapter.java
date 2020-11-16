package com.example.moprog.Drinks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.moprog.R;
import java.util.ArrayList;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder>{
    private ArrayList<DrinksItems> mDrinksItemsList;
    private onItemClickListener mListener;

    public interface onItemClickListener{
        void onItemClick(int p);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        mListener = listener;
    }

    public static class DrinksViewHolder extends RecyclerView.ViewHolder{
        public ImageView drinksImageView;
        public TextView drinksName;
        public TextView drinksPrice;

        public DrinksViewHolder(View itemView, final onItemClickListener listener) {
            super(itemView);
            drinksImageView = itemView.findViewById(R.id.drinksImageView);
            drinksName = itemView.findViewById(R.id.drinksName);
            drinksPrice = itemView.findViewById(R.id.drinksPrice);

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

    public DrinksAdapter(ArrayList<DrinksItems> drinksItemsList){
        mDrinksItemsList = drinksItemsList;
    }

    @Override
    public DrinksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drinks_items, parent, false);
        DrinksViewHolder dvh = new DrinksViewHolder(v, mListener);
        return dvh;
    }

    @Override
    public void onBindViewHolder(DrinksViewHolder holder, int position) {
        DrinksItems currentItems = mDrinksItemsList.get(position);

        holder.drinksImageView.setImageResource(currentItems.getDrinksImageResource());
        holder.drinksName.setText(currentItems.getDrinksName());
        holder.drinksPrice.setText(currentItems.getDrinksPrice());
    }

    @Override
    public int getItemCount() {
        return mDrinksItemsList.size();
    }
}
