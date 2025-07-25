package com.example.stylesphere;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ServiceFragment extends Fragment {

    private RecyclerView recyclerView;
    private DatabaseReference professionalReference;
    private ArrayList<DataClass1> dataList;
    private ProfessionalAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        professionalReference = FirebaseDatabase.getInstance().getReference("PROFESSIONAL");
        dataList = new ArrayList<>();
        adapter = new ProfessionalAdapter(dataList, getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.setOnBookButtonClickListener(new ProfessionalAdapter.OnBookButtonClickListener() {
            @Override
            public void onBookButtonClick(int position) {
                DataClass1 data = dataList.get(position);
                showServiceSelectionDialog(data);
            }
        });

        professionalReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot professionalSnapshot : snapshot.getChildren()) {
                    String phone = professionalSnapshot.getKey();
                    String username = professionalSnapshot.child("username").getValue(String.class);
                    String email = professionalSnapshot.child("email").getValue(String.class);
                    String address = professionalSnapshot.child("address").getValue(String.class); // Add address retrieval
                    DataClass1 data = new DataClass1(username, phone, email, address);
                    dataList.add(data);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void showServiceSelectionDialog(final DataClass1 data) {
        final String[] services = {"Makeover", "Haircuts", "Pedicure", "Manicure", "Body Massage"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Select Service");
        builder.setItems(services, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectedService = services[which];
                Intent intent = new Intent(getActivity(), service.class);
                intent.putExtra("username", data.getUsername());
                intent.putExtra("phoneNumber", data.getPhoneNumber());
                intent.putExtra("email", data.getEmail());
                intent.putExtra("address", data.getAddress()); // Pass address to service activity
                intent.putExtra("serviceName", selectedService);
                startActivity(intent);
            }
        });
        builder.show();
    }

}
