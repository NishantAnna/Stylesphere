package com.example.stylesphere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AddressAdapter extends ArrayAdapter<String> {

    private List<String> addresses;
    private List<Integer> imageIds;
    private Context context;

    public AddressAdapter(@NonNull Context context, int resource, @NonNull List<String> addresses, @NonNull List<Integer> imageIds) {
        super(context, resource, addresses);
        this.context = context;
        this.addresses = addresses;
        this.imageIds = imageIds;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_address, parent, false);
        }

        ImageView ivSalon = convertView.findViewById(R.id.ivSalon);
        TextView tvAddress = convertView.findViewById(R.id.tvAddress);

        // Set the ImageView and TextView values based on your data
        ivSalon.setImageResource(imageIds.get(position));
        tvAddress.setText(addresses.get(position));

        return convertView;
    }
}
