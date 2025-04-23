package com.example.myapps;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterPage extends AppCompatActivity {

    private TextInputEditText emailInput, passwordInput;
    private Button signUpButton;
    private TextView signInText;

    // Firebase Auth
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        // Inisialisasi view
        emailInput = findViewById(R.id.Email);
        passwordInput = findViewById(R.id.password);
        signUpButton = findViewById(R.id.Sing_Up);
        signInText = findViewById(R.id.sign_in);

        // Inisialisasi FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // Tombol SIGN UP
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterPage.this, "Email and Password must not be empty", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(RegisterPage.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(email, password);
                }
            }
        });

        // Klik Sign In -> Pindah ke LoginPage
        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPage.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterPage.this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(RegisterPage.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                        // Redirect to Login or Home
                        Intent intent = new Intent(RegisterPage.this, HomePage.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterPage.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}