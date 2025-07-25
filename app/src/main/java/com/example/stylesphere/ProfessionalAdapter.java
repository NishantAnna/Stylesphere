package com.example.stylesphere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfessionalAdapter extends RecyclerView.Adapter<ProfessionalAdapter.ProfessionalViewHolder> {

    private List<DataClass1> dataList;
    private Context context;
    private OnBookButtonClickListener mListener;

    public ProfessionalAdapter(List<DataClass1> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    public interface OnBookButtonClickListener {
        void onBookButtonClick(int position);
    }

    public void setOnBookButtonClickListener(OnBookButtonClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ProfessionalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_professional, parent, false);
        return new ProfessionalViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionalViewHolder holder, int position) {
        DataClass1 data = dataList.get(position);
        holder.username.setText(data.getUsername());
        holder.phoneNumber.setText(data.getPhoneNumber());
        holder.email.setText(data.getEmail());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ProfessionalViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        TextView phoneNumber;
        TextView email;
        Button bookButton;

        public ProfessionalViewHolder(@NonNull View itemView, final OnBookButtonClickListener listener) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);
            email = itemView.findViewById(R.id.email);
            bookButton = itemView.findViewById(R.id.bookButton);

            bookButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onBookButtonClick(position);
                        }
                    }
                }
            });
        }
    }
}
