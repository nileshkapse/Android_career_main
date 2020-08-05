package com.example.androidcareermain;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

     DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer=findViewById(R.id.draw_la);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fra_cont, new mainhome()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
    }
    public void exp(View view)
    {
        Intent intent = new Intent(home.this, expert.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fra_cont, new mainhome()).commit();
                break;
            case R.id.gallery:
                getSupportFragmentManager().beginTransaction().replace(R.id.fra_cont, new gallery_frag()).commit();
                break;
            case R.id.contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fra_cont, new contact()).commit();
                break;
            case R.id.blog:
                getSupportFragmentManager().beginTransaction().replace(R.id.fra_cont, new blog()).commit();
                break;
            case R.id.ser:
                getSupportFragmentManager().beginTransaction().replace(R.id.fra_cont, new service()).commit();
                break;
            case R.id.itr:
                getSupportFragmentManager().beginTransaction().replace(R.id.fra_cont, new itr()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
