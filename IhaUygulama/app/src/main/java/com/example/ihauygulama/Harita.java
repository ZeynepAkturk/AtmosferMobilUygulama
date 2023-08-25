package com.example.ihauygulama;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Harita extends AppCompatActivity {

    ImageView harita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harita);
        harita=findViewById(R.id.imageView3);
        Toolbar toolbar = findViewById(R.id.include_harita);
        setSupportActionBar(toolbar);
        if(UcusVerileriAnasayfa.il=="Bursa")
        {
            harita.setVisibility(View.VISIBLE);
        }
        else
        {
            harita.setVisibility(View.INVISIBLE);

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent sayfa_gecis;
        if (id == R.id.ucusverileri) {
            sayfa_gecis = new Intent(this, UcusVerileriAnasayfa.class);
            startActivity(sayfa_gecis);
        }

        if (id == R.id.anasayfa) {
            sayfa_gecis = new Intent(this, MainActivity.class);
            startActivity(sayfa_gecis);
        }
        if(id==R.id.harita)
        {
            sayfa_gecis = new Intent(this, Harita.class);
            startActivity(sayfa_gecis);
        }
        return true;

    }
}