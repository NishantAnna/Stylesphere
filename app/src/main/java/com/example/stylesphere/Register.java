package com.example.stylesphere;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDatabaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://stylesphere-9f4bd-default-rtdb.firebaseio.com/");

        final EditText username = findViewById(R.id.username);
        final EditText email = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        final EditText pass = findViewById(R.id.pass);
        final EditText conPassword = findViewById(R.id.conPassword);

        final Button register = findViewById(R.id.Register);
        final TextView login = findViewById(R.id.Login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nameTxt = username.getText().toString();
                final String emailTxt = email.getText().toString();
                final String passwordTxt = pass.getText().toString();
                final String phoneTxt = phone.getText().toString();
                final String conPasswordTxt = conPassword.getText().toString();

                if (nameTxt.isEmpty() || emailTxt.isEmpty() || passwordTxt.isEmpty() || phoneTxt.isEmpty()) {
                    Toast.makeText(Register.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                } else {
                    mDatabaseReference.child("USER").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(phoneTxt)) {
                                Toast.makeText(Register.this, "Phone number already exists", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            if (!TextUtils.isEmpty(emailTxt) && Patterns.EMAIL_ADDRESS.matcher(emailTxt).matches()) {
                                if (!TextUtils.isEmpty(phoneTxt) && Patterns.PHONE.matcher(phoneTxt).matches()) {
                                    if (!TextUtils.isEmpty(passwordTxt) && passwordTxt.length() >= 6 && passwordTxt.equals(conPasswordTxt)) {
                                        saveUserInfoInPrefs(nameTxt, emailTxt, phoneTxt, conPasswordTxt, passwordTxt);
                                        mDatabaseReference.child("USER").child(phoneTxt).child("username").setValue(nameTxt);
                                        mDatabaseReference.child("USER").child(phoneTxt).child("email").setValue(emailTxt);
                                        mDatabaseReference.child("USER").child(phoneTxt).child("pass").setValue(passwordTxt);
                                        Toast.makeText(Register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Register.this, stylesphere.class));
                                        finish();
                                    } else {
                                        Toast.makeText(Register.this, "Passwords do not match or are too short", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(Register.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(Register.this, "Enter a valid email address", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }

    private void saveUserInfoInPrefs(String userName, String userEmail, String userPhone, String userConPassword, String userPassword) {
        // Save user information in SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserName", userName);
        editor.putString("UserEmail", userEmail);
        editor.putString("UserPhone", userPhone);
        editor.putString("UserConPassword", userConPassword);
        editor.putString("UserPassword", userPassword);
        editor.apply();
    }
}
