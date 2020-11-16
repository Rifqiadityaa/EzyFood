package com.example.moprog.Drinks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moprog.Foods.FoodsActivity;
import com.example.moprog.OrderDrinks.OrderMineralWater;
import com.example.moprog.R;
import com.example.moprog.OrderDrinks.OrderCoffee;
import com.example.moprog.OrderDrinks.OrderOrangeJuice;
import com.example.moprog.OrderDrinks.OrderSoda;
import com.example.moprog.UserOrder.UserOrderActivity;

import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {
    private ArrayList<DrinksItems> mDrinksItemsList = new ArrayList<>();
    private RecyclerView mDrinksRecyclerView;
    private DrinksAdapter mDrinksAdapter;
    private RecyclerView.LayoutManager mDrinksLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button toUserOrderBtn = (Button)findViewById(R.id.buttonToUserOrder);

        toUserOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrinksActivity.this, UserOrderActivity.class));
            }
        });

        createDrinksList();
        createDrinksRecycleView();
    }

    public void redirectDrinksActivity(int pos){
        Intent i;

        switch (pos){
            case 0:
                i = new Intent(this, OrderMineralWater.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(this, OrderCoffee.class);
                startActivity(i);
                break;
            case 2:
                i = new Intent(this, OrderOrangeJuice.class);
                startActivity(i);
                break;
            case 3:
                i = new Intent(this, OrderSoda.class);
                startActivity(i);
                break;
        }
    }

    public void createDrinksList(){
        mDrinksItemsList.add(new DrinksItems(R.drawable.mineralwater, "Mineral Water", "Rp 15.000"));
        mDrinksItemsList.add(new DrinksItems(R.drawable.coffeecup, "Coffee", "Rp 30.000"));
        mDrinksItemsList.add(new DrinksItems(R.drawable.orangejuice, "Orange Juice", "Rp 25.000"));
        mDrinksItemsList.add(new DrinksItems(R.drawable.sodacan, "Canned Soda", "Rp 20.000"));
    }

    public void createDrinksRecycleView(){
        mDrinksRecyclerView = findViewById(R.id.drinksRecycleView);
        mDrinksRecyclerView.setHasFixedSize(true);
        mDrinksLayoutManager = new LinearLayoutManager(this);
        mDrinksAdapter = new DrinksAdapter(mDrinksItemsList);
        mDrinksRecyclerView.setLayoutManager(mDrinksLayoutManager);
        mDrinksRecyclerView.setAdapter(mDrinksAdapter);
        mDrinksAdapter.setOnItemClickListener(new DrinksAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                redirectDrinksActivity(pos);
            }
        });
    }
}