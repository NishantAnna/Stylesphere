package com.example.stylesphere;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DelhiSalon extends AppCompatActivity {

    private ListView addressListView;
    private AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi_salon);

        addressListView = findViewById(R.id.addressListView4);
        List<String> mumbaiAddresses = new ArrayList<>();
        mumbaiAddresses.add("Call: +91 11 2685 26621\n" +
                "\n" +
                "Timing: 10:00 am - 8:00 pm \n" +
                "Address: Affinity Salon - Green Park, Def Col, Khan Market & Other Outlets, Delhi\n");

        mumbaiAddresses.add("Call: +91 9718 188 181\n" +
                "\n" +
                "Timing: 11:00 am - 8:30 pm\n" +
                "Address: BBLUNT - M Block Market, GK II,Delhi\n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +91 11 4359 6927\n" +
                "\n" +
                "Address: Geetanjali Salon - GK I, Janakpuri, Khan Market & Other Outlets, Delhi \n" +
                "\n" +
                "Highlights: Wifi Available\n" +
                "\n" +
                "Services Offered: Keratin\n" +
                "\n" +
                " ");
        mumbaiAddresses.add("Call: +91 12 4466 5465 \n\n" +
                "\n" +
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address:  Monsoon Salon & Spa - Dwarka, Rajouri Garden, GGN & Other Outlets, Delhi\n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +91 9999 318 102\n" +
                "\n" +
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address: DMartina Wu Salon- C93, Geetanjali Marg, Block C, Shivalik Colony, Malviya Nagar, Delhi \n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +91 11 4709 8774 &\n" +
                "\n" +"Timings | 10 AM - 8 PM\n" +
                "Address:Jawed Habib Hair & Beauty Salon - Lajpat Nagar II, Hauz Khas, Khan Market & Other Outlets, Delhi \n");

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
