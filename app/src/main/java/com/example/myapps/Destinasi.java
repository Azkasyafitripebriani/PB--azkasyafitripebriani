package com.example.myapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class Destinasi extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destinasi);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setButtonAction(R.id.btnwisata1, "Bukittinggi Sumatera Barat");
        setButtonAction(R.id.btnwisata2, "Pesisir Selatan Sumatera Barat");
        setButtonAction(R.id.btnwisata3, "Kepulauan Mentawai Sumatera Barat");
        setButtonAction(R.id.btnwisata4, "Kabupaten Agam Sumatera Barat");
        setButtonAction(R.id.btnwisata5, "Kabupaten Solok Sumatera Barat");
        setButtonAction(R.id.btnwisata6, "Pariaman Sumatera Barat");
        setButtonAction(R.id.btnwisata7, "Padang Panjang Sumatera Barat");
        setButtonAction(R.id.btnwisata8, "Sawahlunto Sumatera Barat");
    }

    private void setButtonAction(int buttonId, final String query) {
        findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/search?q=" + Uri.encode(query)));
                startActivity(intent);
            }
        });
    }
}