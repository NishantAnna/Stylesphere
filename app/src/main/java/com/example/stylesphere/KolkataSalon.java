package com.example.stylesphere;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class KolkataSalon extends AppCompatActivity {

    private ListView addressListView;
    private AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolkata_salon);

        addressListView = findViewById(R.id.addressListView6);
        List<String> mumbaiAddresses = new ArrayList<>();
        mumbaiAddresses.add("Call: +91 9247200375\n" +
                "\n" +
                "Name :KEYASETH MEDISPA\n"+
                "Timing: 10:00 am - 8:00 pm \n" +
                "Address:  3rd Floor, Shopping Bag Production, 180, N.S.Avenue, Kolkata\n");

        mumbaiAddresses.add("Call: +91 9640000103\n" +
                "\n" +
                "Name :Maroon International Unisem\n"+
                "Timing: 11:00 am - 8:30 pm\n" +
                "Address: Sahid Mangal Pandey Sarani Rd, Kolkata\n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +91 (040)67116641\n" +
                "\n" +
                "Name :UNIQUE HAIR & BEAUTY FAMILY SALON\n"+
                "Timing: 11:00 am - 8:30 pm\n" +
                "Address:144, Bireswar Banerjee Street Bhadrakali Hoogly, Deshbandhu Park, Hindmotor, Kolkata\n" +
                "\n" +
                "Highlights: Wifi Available\n" +
                "\n" +
                "Services Offered: Keratin\n" +
                "\n" +
                " ");
        mumbaiAddresses.add("Call: +91 76800 20493\n\n" +
                "\n" +
                "Name :Green Trends\n"+
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address:  SPENCERS HYPER STORE, CLUB TOWN HEIGHTS, 14, Barrackpore Trunk Rd, Rathtala, Kolkata\n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +91 99287 95959\n" +
                "\n" +
                "Name :Ekta Ladies Beaute Salon and Spa\n"+
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address:   493, Grand Trunk Rd, Naora, Shibpur \n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +91 91422 91234\n" +
                "\n" +
                "Name :Soft touch ladies beauty parlour & spa\n"+
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address: Soft Touch Ladies Beauty Parlour, 125, Kazi Para Rd, Parnasree Palli, Behala, Kolkata\n");

        // Add more addresses as needed

        List<Integer> imageIds = new ArrayList<>();
        imageIds.add(R.drawable.salon1); // Image corresponding to Address 1
        imageIds.add(R.drawable.salon2); // Image corresponding to Address 2
        imageIds.add(R.drawable.salon3); // Image corresponding to Address 3
        imageIds.add(R.drawable.salon4); // Image corresponding to Address 3
        imageIds.add(R.drawable.salon5); // Image corresponding to Address 3
        imageIds.add(R.drawable.salon6); // Image corresponding to Address 3

        // Add more image resource IDs as needed

        addressAdapter = new AddressAdapter(this, R.layout.list_item_address, mumbaiAddresses, imageIds);
        addressListView.setAdapter(addressAdapter);
    }
}
