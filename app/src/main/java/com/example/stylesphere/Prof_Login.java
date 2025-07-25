package com.example.stylesphere;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Prof_Login extends AppCompatActivity {
    com.google.firebase.database.DatabaseReference DatabaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://stylesphere-9f4bd-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_login);

        final EditText phone=findViewById(R.id.P_phone);
        final EditText password=findViewById(R.id.P_password);
        final Button loginbtn=findViewById(R.id.T_Login);
        final TextView registerNowBtn=findViewById(R.id.T_Reg_Now);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phoneTxt=phone.getText().toString();
                final String passwordTxt=password.getText().toString();

                if(phoneTxt.isEmpty()||passwordTxt.isEmpty()){
                    Toast.makeText(Prof_Login.this,"Please enter your mobile or password", Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseReference.child("PROFESSIONAL").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(phoneTxt)) {
                                final String getPassword = snapshot.child(phoneTxt).child("pass").getValue(String.class);
                                if (getPassword.equals(passwordTxt)) {
                                    Toast.makeText(Prof_Login.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Prof_Login.this, rm.class));
                                    finish();
                                }
                                else {
                                    Toast.makeText(Prof_Login.this, "Wrong password", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(Prof_Login.this, "Wrong Phone No.", Toast.LENGTH_SHORT).show();
                            }

                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });
        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Prof_Login.this, Prof_Register.class));
            }
        });

    }
}
