package com.example.moprog.UserOrder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moprog.OrderDrinks.OrderMineralWater;
import com.example.moprog.R;
import com.example.moprog.PaySuccess.PaySuccessActivity;

import java.util.ArrayList;

public class UserOrderActivity extends AppCompatActivity {
    private ArrayList<UserOrderItems> mUserOrderItemsList = new ArrayList<>();
    private RecyclerView mUserOrderRecyclerView;
    private UserOrderAdapter mUserOrderAdapter;
    private RecyclerView.LayoutManager mUserOrderLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button btn = (Button)findViewById(R.id.buttonPay);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserOrderActivity.this, PaySuccessActivity.class));
            }
        });

        createUserOrderList();
        createRecycleView();
    }

    public void removeUserOrderItem(int pos){
        mUserOrderItemsList.remove(pos);
        mUserOrderAdapter.notifyItemRemoved(pos);
    }

    public void redirectActivity(int pos){
        Intent i;

        switch (pos){
            case 0:
                i = new Intent(this, OrderMineralWater.class);
                startActivity(i);
                break;
        }
    }

    public void createUserOrderList(){
        mUserOrderItemsList.add(new UserOrderItems(R.drawable.doughnut, "Doughnut", "1 x Rp 15.000"));
        mUserOrderItemsList.add(new UserOrderItems(R.drawable.coffeecup, "Coffee", "3 x Rp 30.000"));
        mUserOrderItemsList.add(new UserOrderItems(R.drawable.hamburger, "Hamburger", "2 x Rp 25.000"));
        mUserOrderItemsList.add(new UserOrderItems(R.drawable.sodacan, "Canned Soda", "3 x Rp 20.000"));
    }

    public void createRecycleView(){
        mUserOrderRecyclerView = findViewById(R.id.userOrderRecycleView);
        mUserOrderRecyclerView.setHasFixedSize(true);
        mUserOrderLayoutManager = new LinearLayoutManager(this);
        mUserOrderAdapter = new UserOrderAdapter(mUserOrderItemsList);
        mUserOrderRecyclerView.setLayoutManager(mUserOrderLayoutManager);
        mUserOrderRecyclerView.setAdapter(mUserOrderAdapter);
        mUserOrderAdapter.setOnItemClickListener(new UserOrderAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                redirectActivity(pos);
            }

            @Override
            public void onRemoveClick(int pos) {
                removeUserOrderItem(pos);
            }
        });
    }
}