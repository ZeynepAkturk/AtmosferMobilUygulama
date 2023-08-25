package com.example.ihauygulama;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.List;

public class UcusVerileri extends AppCompatActivity {

    private TextView yukseklik, basinc,sicaklik,nem,enlem, boylam,havakalitesi;


   /* private String[] yukseklik_textList = {"2", "7","12", "17", "22","24","25","25","26","26","27"};
    private String[] basinc_textList = {"1013.25", "1013.20", "1012.98", "1012.50", "1011.90","1011.23","1011.12","1010.00","988.98","970.99","970.98"};
    private String[] sicaklik_textList = {"8", "8", "8", "8","9","9","9","9","9"};
    private String[] nem_textList = {"65", "65", "65", "67", "65","66","67","65","68","69","69"};
    private String[] enlem_textList = {"41.510990", "41.510989", "41.510980", "41.510979", "41.510977","41.510975","41.510960","41.510955","41.510954","41.510980","41.510980"};
    private String[] boylam_textList = {"36.118313", "36.118281", "36.118279", "36.118270", "36.118260","36.118199","36.118100","36.118183","36.118189","36.118192","36.118199"};
    private String[] hiz_textList = {"5", "10", "10", "10", "7","8","9","9","10","9","10"};
    private String[] havakalitesi_textList = {"58", "58", "59", "61", "70","75","80","88","96","100","108"};
    */

    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucus_verileri);

        Toolbar toolbar = findViewById(R.id.include2);
        setSupportActionBar(toolbar);


        yukseklik=(TextView) findViewById(R.id.yukseklik_editText);
        basinc=(TextView) findViewById(R.id.basinc_editText);
        sicaklik=(TextView) findViewById(R.id.sicaklik_editText);
        nem=(TextView) findViewById(R.id.nem_editText);
        enlem=(TextView) findViewById(R.id.enlem_editText);
        boylam=(TextView) findViewById(R.id.boylam_editText);

        havakalitesi=(TextView) findViewById(R.id.hava_kalitesi_editText);


        veriAl();

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
            sayfa_gecis = new Intent(this, HaritaAnasayfa.class);
            startActivity(sayfa_gecis);
        }
        return true;

    }
    protected void veriAl()
    {

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                DocumentReference ref = db.collection("ucusverisi")
                        .document(UcusVerileriAnasayfa.il)
                        .collection("ilce")
                        .document(UcusVerileriAnasayfa.ilce)
                        .collection("tarih")
                        .document(UcusVerileriAnasayfa.tarih);



               ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {

                            List<String> yukseklik_dizi = (List<String>) documentSnapshot.get("yukseklik");
                            List<String> basinc_dizi = (List<String>) documentSnapshot.get("basinc");
                            List<String> sicaklik_dizi = (List<String>) documentSnapshot.get("sicaklik");
                            List<String> nem_dizi = (List<String>) documentSnapshot.get("nem");
                            List<String> enlem_dizi = (List<String>) documentSnapshot.get("enlem");
                            List<String> boylam_dizi = (List<String>) documentSnapshot.get("boylam");
                            List<String> havakalitesi_dizi = (List<String>) documentSnapshot.get("havakalitesi");


                            // myArray'i diziye dönüştür
                            String[] yukseklik_ = yukseklik_dizi.toArray(new String[0]);
                            String[] basinc_ = basinc_dizi.toArray(new String[0]);
                            String[] sicaklik_ = sicaklik_dizi.toArray(new String[0]);
                            String[] nem_ = nem_dizi.toArray(new String[0]);
                            String[] enlem_ = enlem_dizi.toArray(new String[0]);
                            String[] boylam_ = boylam_dizi.toArray(new String[0]);
                            String[] havakalitesi_ = havakalitesi_dizi.toArray(new String[0]);

                            // diziye eriş ve kullan
                            final Handler handler = new Handler();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    yukseklik.setText(yukseklik_[index]);
                                    basinc.setText(basinc_[index]);
                                    sicaklik.setText(sicaklik_[index]);
                                    nem.setText(nem_[index]);
                                    enlem.setText(enlem_[index]);
                                    boylam.setText(boylam_[index]);
                                    havakalitesi.setText(havakalitesi_[index]);



                                    index++;
                                    if (index == yukseklik_.length) {
                                        index = 0;
                                    }
                                    handler.postDelayed(this, 300); // 2 saniye sonra metin güncelleme

                                }
                            });
                        }}
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UcusVerileri.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

}