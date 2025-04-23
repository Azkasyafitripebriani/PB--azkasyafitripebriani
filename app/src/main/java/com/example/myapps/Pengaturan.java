package com.example.myapps;

import com.example.myapps.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Pengaturan extends AppCompatActivity {

    private ImageView bahasa, tema, privasi, bantuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan); // Pastikan nama file XML-nya benar

        // Inisialisasi ImageView
        bahasa = findViewById(R.id.bahasa);
        tema = findViewById(R.id.Tema);
        privasi = findViewById(R.id.Privasi);
        bantuan = findViewById(R.id.bantuan);

        // Klik listener untuk masing-masing item pengaturan
        bahasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ganti dengan aktivitas atau logika yang sesuai
                Intent intent = new Intent(Pengaturan.this, BahasaActivity.class);
                startActivity(intent);
            }
        });

        tema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pengaturan.this, TemaActivity.class);
                startActivity(intent);
            }
        });

        privasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pengaturan.this, PrivasiActivity.class);
                startActivity(intent);
            }
        });

        bantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pengaturan.this, BantuanActivity.class);
                startActivity(intent);
            }
        });

        // Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                startActivity(new Intent(Pengaturan.this, HomePage.class));
                return true;
            } else if (id == R.id.nav_pengaturan) {
                // Sudah di halaman pengaturan
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(Pengaturan.this, ProfileActivity.class));
                return true;
            }
            return false;
        });
    }
}