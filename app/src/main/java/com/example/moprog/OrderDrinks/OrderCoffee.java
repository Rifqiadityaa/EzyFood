package com.example.moprog.OrderDrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moprog.Drinks.DrinksActivity;
import com.example.moprog.MainActivity;
import com.example.moprog.PaySuccess.PaySuccessActivity;
import com.example.moprog.R;
import com.example.moprog.UserOrder.UserOrderActivity;

public class OrderCoffee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_coffee);

        Button toDrinksBtn = (Button)findViewById(R.id.buttonToDrinks);

        toDrinksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderCoffee.this, DrinksActivity.class));
            }
        });

        Button toUserOrderBtn = (Button)findViewById(R.id.buttonToUserOrder);

        toUserOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderCoffee.this, UserOrderActivity.class));
            }
        });
    }
}