package com.example.moprog.OrderFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moprog.Foods.FoodsActivity;
import com.example.moprog.R;
import com.example.moprog.UserOrder.UserOrderActivity;

public class OrderPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pizza);

        Button toFoodsBtn = (Button)findViewById(R.id.buttonToFoods);

        toFoodsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderPizza.this, FoodsActivity.class));
            }
        });

        Button toUserOrderBtn = (Button)findViewById(R.id.buttonToUserOrder);

        toUserOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderPizza.this, UserOrderActivity.class));
            }
        });
    }
}