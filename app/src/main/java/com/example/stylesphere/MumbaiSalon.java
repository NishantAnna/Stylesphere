package com.example.stylesphere;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MumbaiSalon extends AppCompatActivity {

    private ListView addressListView;
    private AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumbai_salon);

        addressListView = findViewById(R.id.addressListView);
        List<String> mumbaiAddresses = new ArrayList<>();
        mumbaiAddresses.add("Call: +912265550003\n" +
                "\n" +
                "Timing: 10:00 am - 8:00 pm \n" +
                "17-18, Vaitarna, Sir Pochkanwala Road, Off Worli Sea Face, Police Camp Sea Face, Lower Parel, Mumbai");
        mumbaiAddresses.add("Call: +912240065544\n" +
                "\n" +
                "Timing: 11:00 am - 8:30 pm\n" +
                "Address: Shop No. 7 Shravasti C.H.S. Opp Inorbit Mall, Goregaon - Mulund Link Rd, Ekta Nagar, Malad West, Mumbai\n" +
                "\n" +
                "Services Offered: Haircut");
        mumbaiAddresses.add("Call: +912226322050\n" +
                "\n" +
                "Address: HA-3, Aram Nagar One, J.P. Road, Versova, Andheri West, Versova, Andheri West, Mumbai \n" +
                "\n" +
                "Highlights: Wifi Available\n" +
                "\n" +
                "Services Offered: Keratin\n" +
                "\n" +
                " ");
        mumbaiAddresses.add("Call: +912226001726\n" +
                "\n" +
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address: Ground Floor,Grace Classic,14th A Road,, Ahimsa Marg, Khar, Mumbai\n" +
                "\n" +
                "Services Offered: Haircut");
        mumbaiAddresses.add("Call: +912266995555\n" +
                "\n" +
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address: 54, Ambika Bungalow, 10th Road, JVPD Scheme, Juhu, Mumbai\n" +
                "\n" +
                "Services Offered: Haircut");
        mumbaiAddresses.add("Call: +912265762004\n" +
                "\n" +
                "Address: 1 & 2 Amber, Near HSBC Bank, 10th Road, Jvpd Scheme, Juhu, Mumbai");

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
