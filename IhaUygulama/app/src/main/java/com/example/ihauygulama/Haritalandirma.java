package com.example.ihauygulama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.ihauygulama.databinding.ActivityHaritalandirmaBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Haritalandirma extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityHaritalandirmaBinding binding;
    private Button goster_button;
    LatLng sydney = new LatLng(-32.33, 151);
    LatLng TamWorth = new LatLng(-32.083332, 150.916672);
    LatLng NewCastle = new LatLng(-32.916668, 151.750000);
    LatLng Brisbane = new LatLng(-32.470125, 153.021072);
    private ArrayList<LatLng> locationArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHaritalandirmaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        goster_button=findViewById(R.id.goster_button);

        locationArrayList = new ArrayList<>();
        locationArrayList.add(sydney);
        locationArrayList.add(TamWorth);
        locationArrayList.add(NewCastle);
        locationArrayList.add(Brisbane);

        goster_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enlem = "-32.33";
                String boylam = "150.916672";
                LatLng konum = new LatLng(Double.parseDouble(enlem), Double.parseDouble(boylam));


                mMap.addMarker(new MarkerOptions().
                        position(konum).
                        title("Hedef")).
                        setIcon(BitmapDescriptorFactory.fromResource(R.drawable.yesil_ucak));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum, 10.00f));
                for (int i = 0; i < locationArrayList.size(); i++) {

                    // below line is use to add marker to each location of our array list.
                    mMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Marker")
                    .title("Hedef")).
                            setIcon(BitmapDescriptorFactory.fromResource(R.drawable.sari_ucak));


                    // below line is use to zoom our camera on map.
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));

                    // below line is use to move our camera to the specific location.
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList.get(i)));
                }
            }
        });
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

   /* protected void veriAl()
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


                    List<String> enlem_dizi = (List<String>) documentSnapshot.get("enlem");
                    List<String> boylam_dizi = (List<String>) documentSnapshot.get("boylam");
                    List<String> havakalitesi_dizi = (List<String>) documentSnapshot.get("havakalitesi");


                    String[] enlem_ = enlem_dizi.toArray(new String[0]);
                    String[] boylam_ = boylam_dizi.toArray(new String[0]);
                    String[] havakalitesi_ = havakalitesi_dizi.toArray(new String[0]);

                    // diziye eriş ve kullan
                    final Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            enlem.setText(enlem_[index]);
                            boylam.setText(boylam_[index]);
                            havakalitesi.setText(havakalitesi_[index]);



                            index++;
                            if (index == yukseklik_.length) {
                                index = 0;
                            }
                            handler.postDelayed(this, 1000); // 2 saniye sonra metin güncelleme

                        }
                    });
                }}
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Haritalandirma.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }*/


    }