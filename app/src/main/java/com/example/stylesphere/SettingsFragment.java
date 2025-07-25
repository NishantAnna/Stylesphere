package com.example.stylesphere;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    private TextView textViewName, textViewEmail;
    private Button buttonLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Initialize TextViews
        textViewName = view.findViewById(R.id.textViewName);
        textViewEmail = view.findViewById(R.id.textViewEmail);
        buttonLogout = view.findViewById(R.id.buttonLogout);

        // Retrieve and display user information
        displayUserInfo();
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement your logout logic here
                // For example, navigate to the login screen or perform logout operations
                navigateToLogin();
            }
        });

        return view;
    }

    private void displayUserInfo() {
        // Retrieve user information from SharedPreferences
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("UserName", "");
        String userEmail = sharedPreferences.getString("UserEmail", "");

        // Set user information in the UI
        if (!userName.isEmpty()) {
            textViewName.setText("Name: " + userName);
        }
        if (!userEmail.isEmpty()) {
            textViewEmail.setText("Email: " + userEmail);
        }
    }

    private void navigateToLogin() {
        // Clear the user information from SharedPreferences on logout
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        // Create an Intent to start the Login activity
        Intent intent = new Intent(requireActivity(), Login.class);

        // Add any additional flags or extras if needed

        // Start the Login activity and clear the back stack
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        requireActivity().finish(); // Finish the current activity
    }
}
