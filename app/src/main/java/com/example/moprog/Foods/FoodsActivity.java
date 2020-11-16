package com.example.moprog.Foods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moprog.OrderDrinks.OrderCoffee;
import com.example.moprog.OrderFoods.OrderDoughnut;
import com.example.moprog.OrderFoods.OrderHamburger;
import com.example.moprog.OrderFoods.OrderPancake;
import com.example.moprog.OrderFoods.OrderPizza;
import com.example.moprog.R;
import com.example.moprog.UserOrder.UserOrderActivity;

import java.util.ArrayList;

public class FoodsActivity extends AppCompatActivity {
    private ArrayList<FoodsItems> mFoodsItemsList = new ArrayList<>();
    private RecyclerView mFoodsRecyclerView;
    private FoodsAdapter mFoodsAdapter;
    private RecyclerView.LayoutManager mFoodsLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button toUserOrderBtn = (Button)findViewById(R.id.buttonToUserOrder);

        toUserOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodsActivity.this, UserOrderActivity.class));
            }
        });

        createFoodsList();
        createFoodsRecycleView();
    }

    public void redirectFoodsActivity(int pos){
        Intent i;

        switch (pos){
            case 0:
                i = new Intent(this, OrderDoughnut.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(this, OrderHamburger.class);
                startActivity(i);
                break;
            case 2:
                i = new Intent(this, OrderPancake.class);
                startActivity(i);
                break;
            case 3:
                i = new Intent(this, OrderPizza.class);
                startActivity(i);
                break;
        }
    }

    public void createFoodsList(){
        mFoodsItemsList.add(new FoodsItems(R.drawable.doughnut, "Doughnut", "Rp 15.000"));
        mFoodsItemsList.add(new FoodsItems(R.drawable.hamburger, "Hamburger", "Rp 30.000"));
        mFoodsItemsList.add(new FoodsItems(R.drawable.pancake, "Pancake", "Rp 25.000"));
        mFoodsItemsList.add(new FoodsItems(R.drawable.pizzaslice, "Pizza", "Rp 30.000"));
    }

    public void createFoodsRecycleView(){
        mFoodsRecyclerView = findViewById(R.id.foodsRecycleView);
        mFoodsRecyclerView.setHasFixedSize(true);
        mFoodsLayoutManager = new LinearLayoutManager(this);
        mFoodsAdapter = new FoodsAdapter(mFoodsItemsList);
        mFoodsRecyclerView.setLayoutManager(mFoodsLayoutManager);
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);
        mFoodsAdapter.setOnItemClickListener(new FoodsAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                redirectFoodsActivity(pos);
            }
        });
    }
}