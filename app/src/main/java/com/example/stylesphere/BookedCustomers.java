package com.example.stylesphere;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class BookedCustomers extends AppCompatActivity {

    private RecyclerView customersRecyclerView;
    private DatabaseReference bookingReference;
    private DatabaseReference userReference;
    private CustomerAdapter adapter;
    private List<String> bookingsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_customers);

        customersRecyclerView = findViewById(R.id.customersRecyclerView);
        customersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        bookingReference = FirebaseDatabase.getInstance().getReference("Booking");
        userReference = FirebaseDatabase.getInstance().getReference("USER");

        bookingsList = new ArrayList<>();
        adapter = new CustomerAdapter(this, bookingsList);
        customersRecyclerView.setAdapter(adapter);

        // Fetch and display bookings
        fetchBookings();
    }

    private void fetchBookings() {
        bookingReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bookingsList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    final DataClass2.Booking booking = snapshot.getValue(DataClass2.Booking.class);
                    if (booking != null) {
                        userReference.orderByChild("phone").equalTo(booking.getPhone()).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                        String username = userSnapshot.child("username").getValue(String.class);
                                        String email = userSnapshot.child("email").getValue(String.class);

                                        if (username != null && email != null) {
                                            String customerInfo = "Username: " + username +
                                                     "\nEmail: " + email +
                                                    "\nService Name: " + booking.getServiceName() +
                                                    "\nAddress: " + booking.getAddress();
                                            bookingsList.add(customerInfo);
                                            adapter.notifyDataSetChanged();
                                        } else {
                                            Toast.makeText(BookedCustomers.this, "Missing username or email data", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                } else {
                                    Toast.makeText(BookedCustomers.this, "User data for phone number not found", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Toast.makeText(BookedCustomers.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(BookedCustomers.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
