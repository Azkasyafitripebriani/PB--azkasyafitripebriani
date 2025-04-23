package com.example.myapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private TextView profileName, profileEmail;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.txNama);
        profileEmail = findViewById(R.id.txEmail);
        btnLogout = findViewById(R.id.btnLogout);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if (user == null) {
            // Kalau belum login, arahkan ke login
            startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            finish();
        } else {
            // Tampilkan data
            profileEmail.setText(user.getEmail());
            profileName.setText(user.getDisplayName() != null ? user.getDisplayName() : "Pengguna");
        }

        btnLogout.setOnClickListener(v -> {
            auth.signOut();
            startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            finish();
        });
    }
}