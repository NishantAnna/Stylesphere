package com.example.stylesphere;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreditCardDetails extends AppCompatActivity {

    private EditText cardNumberEditText, expiryDateEditText, cvvEditText, upiEditText;
    private Button googlePayButton, phonePeButton, payButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_details);

        cardNumberEditText = findViewById(R.id.cardNumberEditText);
        expiryDateEditText = findViewById(R.id.expiryDateEditText);
        cvvEditText = findViewById(R.id.cvvEditText);
        upiEditText = findViewById(R.id.upiEditText);
        payButton = findViewById(R.id.payButton);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upiId = upiEditText.getText().toString();
                if (!upiId.isEmpty()) {
                    confirmPayment("UPI");
                } else {
                    if (validateCardDetails()) {
                        confirmPayment("Card");
                    }
                }
            }
        });

    }

    private boolean validateCardDetails() {
        String cardNumber = cardNumberEditText.getText().toString().trim();
        String expiryDate = expiryDateEditText.getText().toString().trim();
        String cvv = cvvEditText.getText().toString().trim();

        if (cardNumber.isEmpty() || cardNumber.length() < 16) {
            Toast.makeText(this, "Enter a valid 16-digit card number", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (expiryDate.isEmpty() || !expiryDate.matches("\\d{2}/\\d{4}")) {
            Toast.makeText(this, "Enter a valid expiry date in the format MM/YY", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (cvv.isEmpty() || cvv.length() < 3) {
            Toast.makeText(this, "Enter a valid CVV", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void confirmPayment(String paymentMethod) {
        String message = "Paying with " + paymentMethod;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        if (paymentMethod.equals("Card")) {
            // Handle payment with card
            // Optionally, start the CODBook activity after payment is successful
            startActivity(new Intent(this, CODBook.class));
            finish();
        } else if (paymentMethod.equals("UPI")) {
            // Handle payment with UPI
            String upiId = upiEditText.getText().toString();
            if (upiId.isEmpty()) {
                Toast.makeText(this, "Please enter UPI ID", Toast.LENGTH_SHORT).show();
                return;
            }

            // Implement payment logic for UPI
            Toast.makeText(this, "Paying with UPI: " + upiId, Toast.LENGTH_SHORT).show();

            // Optionally, start the CODBook activity after payment is successful
            startActivity(new Intent(this, CODBook.class));
            finish();
        }
    }
}
