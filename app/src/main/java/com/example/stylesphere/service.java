package com.example.stylesphere;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class service extends AppCompatActivity {

    private TextView usernameTextView, phoneNumberTextView, emailTextView, serviceNameTextView;
    private EditText addressEditText; // Add EditText for address
    private RadioGroup paymentOptionsRadioGroup;
    private Button confirmBookingButton;
    private DatabaseReference bookingReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        usernameTextView = findViewById(R.id.usernameTextView);
        phoneNumberTextView = findViewById(R.id.phoneNumberTextView);
        emailTextView = findViewById(R.id.emailTextView);
        serviceNameTextView = findViewById(R.id.serviceNameTextView);
        addressEditText = findViewById(R.id.addressEditText); // Initialize EditText for address
        paymentOptionsRadioGroup = findViewById(R.id.paymentRadioGroup);
        confirmBookingButton = findViewById(R.id.confirmBookingButton);

        Intent intent = getIntent();
        if (intent != null) {
            String username = intent.getStringExtra("username");
            String phoneNumber = intent.getStringExtra("phoneNumber");
            String email = intent.getStringExtra("email");
            String serviceName = intent.getStringExtra("serviceName");

            if (username != null) usernameTextView.setText(username);
            if (phoneNumber != null) phoneNumberTextView.setText(phoneNumber);
            if (email != null) emailTextView.setText(email);
            if (serviceName != null) serviceNameTextView.setText(serviceName);
        }

        bookingReference = FirebaseDatabase.getInstance().getReference("Booking");

        confirmBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedPaymentId = paymentOptionsRadioGroup.getCheckedRadioButtonId();
                if (selectedPaymentId != -1) {
                    RadioButton selectedPayment = findViewById(selectedPaymentId);
                    String paymentOption = selectedPayment.getText().toString();

                    // Get professional's phone number (used as a unique key for the booking)
                    String phoneNumber = phoneNumberTextView.getText().toString();

                    // Validate address
                    String address = addressEditText.getText().toString();
                    if (address.isEmpty()) {
                        Toast.makeText(service.this, "Please enter an address", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Create a booking object
                    DataClass1.Booking booking = new DataClass1.Booking(
                            usernameTextView.getText().toString(),
                            phoneNumber,
                            emailTextView.getText().toString(),
                            serviceNameTextView.getText().toString(),
                            address, // Get address from EditText
                            paymentOption
                    );

                    if (paymentOption.equals("Pay in Cash")) {
                        // Store booking in the database under the professional's phone number
                        bookingReference.child(phoneNumber).setValue(booking);

                        // Display a confirmation message
                        Toast.makeText(service.this, "Booking confirmed with Cash on Delivery", Toast.LENGTH_SHORT).show();

                        // Navigate to the next interface for Cash on Delivery
                        Intent intent = new Intent(service.this, CODBook.class);
                        startActivity(intent);
                        finish(); // Optional, to close this activity
                    } else if (paymentOption.equals("Credit Card")) {
                        // Store booking in the database under the professional's phone number
                        bookingReference.child(phoneNumber).setValue(booking);

                        // Display a confirmation message
                        Toast.makeText(service.this, "Proceed to Payment", Toast.LENGTH_SHORT).show();

                        // Navigate to the next interface for Credit Card payment
                        Intent intent = new Intent(service.this, CreditCardDetails.class);
                        startActivity(intent);
                        finish(); // Optional, to close this activity
                    } else {
                        // Handle other payment options if needed
                    }
                } else {
                    Toast.makeText(service.this, "Please select a payment option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}