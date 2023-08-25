package com.example.ihauygulama;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    Button ucusVerileri_buton;
    Button haritalandirma_buton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ucusVerileri_buton= findViewById(R.id.ucusverileri_button);
        haritalandirma_buton=findViewById(R.id.harita_button);

        ucusVerileri_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ucusVeri_sayfasi=new Intent(getApplicationContext(),UcusVerileriAnasayfa.class);
                startActivity(ucusVeri_sayfasi);

            }
        });

        haritalandirma_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent harita_sayfasi=new Intent(getApplicationContext(), HaritaAnasayfa.class);
                startActivity(harita_sayfasi);
            }
        });



    }



}