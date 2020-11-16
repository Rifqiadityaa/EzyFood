package com.example.moprog.PaySuccess;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.moprog.R;
import java.util.ArrayList;

public class PaySuccessAdapter extends RecyclerView.Adapter<PaySuccessAdapter.PaySuccessViewHolder> {
    private ArrayList<PaySuccessItems> mPaySuccessItemsList;

    public static class PaySuccessViewHolder extends RecyclerView.ViewHolder {
        public ImageView paySuccessImageView;
        public TextView paySuccessName;
        public TextView paySuccessPrice;

        public PaySuccessViewHolder(View itemView) {
            super(itemView);
            paySuccessImageView = itemView.findViewById(R.id.paySuccessImageView);
            paySuccessName = itemView.findViewById(R.id.paySuccessName);
            paySuccessPrice = itemView.findViewById(R.id.paySuccessPrice);
        }
    }

    public PaySuccessAdapter(ArrayList<PaySuccessItems> paySuccessItemsList) {
        mPaySuccessItemsList = paySuccessItemsList;
    }

    @Override
    public PaySuccessViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pay_success_items, parent, false);
        PaySuccessViewHolder psvh = new PaySuccessViewHolder(v);
        return psvh;
    }

    @Override
    public void onBindViewHolder(PaySuccessViewHolder holder, int position) {
        PaySuccessItems currentItems = mPaySuccessItemsList.get(position);

        holder.paySuccessImageView.setImageResource(currentItems.getPaySuccessImageResource());
        holder.paySuccessName.setText(currentItems.getPaySuccessName());
        holder.paySuccessPrice.setText(currentItems.getPaySuccessPrice());
    }

    @Override
    public int getItemCount() {
        return mPaySuccessItemsList.size();
    }
}
