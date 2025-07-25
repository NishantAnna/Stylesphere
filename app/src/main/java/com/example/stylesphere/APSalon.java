package com.example.stylesphere;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class APSalon extends AppCompatActivity {

    private ListView addressListView;
    private AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apsalon);

        addressListView = findViewById(R.id.addressListView3);
        List<String> mumbaiAddresses = new ArrayList<>();
        mumbaiAddresses.add("Call: +91 93813 19231\n" +
                "\n" +
                "Timing: 10:00 am - 8:00 pm \n" +
                "Address: 10-15-43, VRINDA GRAND, Trunk Rd, below HOTEL, opp. RSR KALYANA MANDAPAM, Shanthi Nagar, Kavali, Andhra Pradeshn");

        mumbaiAddresses.add("Call: +91 1800 123 1952\n\n" +
                "\n" +
                "Timing: 11:00 am - 8:30 pm\n" +
                "Address: First Floor, 18, 1058/1, High Road, Thotapalyam, Chittoor, Andhra Pradesh\n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +91 90327 41054\n\n" +
                "\n" +
                "Address: SHOP NO 4, TB Rd, Ammavarisala Bazar, Allagadda, Andhra Pradesh\n" +
                "\n" +
                "Highlights: Wifi Available\n" +
                "\n" +
                "Services Offered: Keratin\n" +
                "\n" +
                " ");
        mumbaiAddresses.add("Call: +91 76800 20493\n\n" +
                "\n" +
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address: MR33+GG4, Cross Rd, Kalikiri, Andhra Pradesh\n" +
                "\n" +
                "Services Offered: Haircut");
        mumbaiAddresses.add("Call: +91 99287 95959\n" +
                "\n" +
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address: DOOR N 0: 4-1-429, 1ST FLOOR, SURVEY NO: 191, BESIDES RELIANCE TRENDS, 1, PARNAPALLI ROAD, KADAPA, Andhra Pradesh \n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +91 91422 91234\n" +
                "\n" +
                "Address: 1st Floor, MVP Main Rd, above Apollo Pharmacy, beside HDFC bank, Beside SBH, Sector- 6, MVP Colony, Visakhapatnam, Andhra Pradesh \n");

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
