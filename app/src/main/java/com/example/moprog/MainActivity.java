package com.example.moprog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.moprog.Drinks.DrinksActivity;
import com.example.moprog.Foods.FoodsActivity;
import com.example.moprog.UserOrder.UserOrderActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    //variables
    private CardView cardDrinks, cardFoods, cardSnacks, cardTopup;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //set nav drawer
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.swipeNav);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navSwipeOpen, R.string.navSwipeClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        //biar saat salah satu menu di klik nanti akan stay di menu yg di klik saat drawer nav dibuka lagi.
        navigationView.setCheckedItem(R.id.swipeHome);

        //menaruh onClickEventListener pada setiap ViewCard di main menu.
        cardDrinks = (CardView) findViewById (R.id.cardViewDrinks);
        cardFoods = (CardView) findViewById (R.id.cardViewFoods);

        cardDrinks.setOnClickListener(this);
        cardFoods.setOnClickListener(this);
    }

    //membuat navigation drawer tertutup saaat pencet back button pada handphone, bukan keluar aplikasi.
    @Override
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    //melakukan redirect ke activity yang lain berdasarkan cardview yang dipencet oleh user.
    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.cardViewDrinks:
                i = new Intent(this, DrinksActivity.class);
                startActivity(i);
                break;
            case R.id.cardViewFoods:
                i = new Intent(this, FoodsActivity.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent i;

        switch (menuItem.getItemId()){
            case R.id.swipeHome:
                i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.swipeDrinks:
                i = new Intent(this, DrinksActivity.class);
                startActivity(i);
                break;
            case R.id.swipeFoods:
                i = new Intent(this, FoodsActivity.class);
                startActivity(i);
                break;
            case R.id.swipeUserOrder:
                i = new Intent(this, UserOrderActivity.class);
                startActivity(i);
                break;
        }
        //habis di klik terus redirect, nav drawer ditutup
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}