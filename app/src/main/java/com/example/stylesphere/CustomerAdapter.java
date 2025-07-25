package com.example.stylesphere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private Context mContext;
    private List<String> mCustomerList;

    public CustomerAdapter(Context context, List<String> customerList) {
        mContext = context;
        mCustomerList = customerList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_list_item, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        String customerInfo = mCustomerList.get(position);
        holder.bind(customerInfo);
    }

    @Override
    public int getItemCount() {
        return mCustomerList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {

        private TextView usernameTextView;
        private TextView emailTextView;
        private TextView serviceTextView;
        private TextView addressTextView;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            serviceTextView = itemView.findViewById(R.id.serviceTextView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
        }

        public void bind(String customerInfo) {
            String[] customerDetails = customerInfo.split("\n");
            usernameTextView.setText(customerDetails[0].replace("Username: ", ""));
            emailTextView.setText(customerDetails[1].replace("Email: ", ""));
            serviceTextView.setText(customerDetails[2].replace("Service Name: ", ""));
            addressTextView.setText(customerDetails[3].replace("Address: ", ""));
        }
    }
}
