package com.example.moprog.PaySuccess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moprog.MainActivity;
import com.example.moprog.R;

import java.util.ArrayList;

public class PaySuccessActivity extends AppCompatActivity {
    private ArrayList<PaySuccessItems> mPaySuccessItemsList = new ArrayList<>();
    private RecyclerView mPaySuccessRecyclerView;
    private PaySuccessAdapter mPaySuccessAdapter;
    private RecyclerView.LayoutManager mPaySuccessLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_success);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button btn = (Button)findViewById(R.id.buttonToUserOrder);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaySuccessActivity.this, MainActivity.class));
            }
        });

        createPaySuccessList();
        createRecycleView();
    }

    public void createPaySuccessList(){
        mPaySuccessItemsList.add(new PaySuccessItems(R.drawable.doughnut, "Doughnut", "1 x Rp 15.000"));
        mPaySuccessItemsList.add(new PaySuccessItems(R.drawable.coffeecup, "Coffee", "3 x Rp 30.000"));
        mPaySuccessItemsList.add(new PaySuccessItems(R.drawable.hamburger, "Hamburger", "2 x Rp 25.000"));
        mPaySuccessItemsList.add(new PaySuccessItems(R.drawable.sodacan, "Canned Soda", "3 x Rp 20.000"));
    }

    public void createRecycleView(){
        mPaySuccessRecyclerView = findViewById(R.id.paySuccessRecycleView);
        mPaySuccessRecyclerView.setHasFixedSize(true);
        mPaySuccessLayoutManager = new LinearLayoutManager(this);
        mPaySuccessAdapter = new PaySuccessAdapter(mPaySuccessItemsList);
        mPaySuccessRecyclerView.setLayoutManager(mPaySuccessLayoutManager);
        mPaySuccessRecyclerView.setAdapter(mPaySuccessAdapter);
    }
}