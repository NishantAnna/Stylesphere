package com.example.stylesphere;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BangaloreSalon extends AppCompatActivity {

    private ListView addressListView;
    private AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangalore_salon);

        addressListView = findViewById(R.id.addressListView1);
        List<String> mumbaiAddresses = new ArrayList<>();
        mumbaiAddresses.add("Call: +918066085259\n" +
                "\n" +
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address: No.18, Jaladarsini Layout,Hbcs Layout, New BEL Road, Bangalore\n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +918041205735\n" +
                "\n" +
                "Timing: 10:30 am - 8:30 pm\n" +
                "Address: 6, 253, 46Th Cross, 8Th Block, Near Sangam Circle, Jayanagar, Bangalore\n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +919945726131\n" +
                "\n" +
                "Timing: 10:30 am - 9:00 pm\n" +
                "Address: Evergreen Parc, First Floor, 136, 1St Cross, 5Th Block, Srirampuram, Koramangala, Bangalore\n" +
                "\n" +
                "Services Offered: Threading");

        mumbaiAddresses.add("Call: +917624996800\n" +
                "\n" +
                "Timing: 9:30 am - 9:30 pm\n" +
                "Address: Commission, Lavelle Road, Bangalore(Get Directions)\n" +
                "\n" +
                "Services Offered: HaircutHair ColourHair StylingWaxing");

        mumbaiAddresses.add("Call: +918025533833\n" +
                "\n" +
                "Timing: 8:30 am - 8:30 pm\n" +
                "Address: 16 & 17, Raheja Arcade, 5Th Block, Koramangala, Bangalore(Get Directions)\n" +
                "\n" +
                "Services Offered: Waxing");

        mumbaiAddresses.add("Call: +918040993035\n" +
                "\n" +
                "Timing: 10:00 am - 8:30 pm\n" +
                "Address: # 43, Cambridge Layout, Ii Cross, Shirdi Sai Baba Mandir Road, Someshwarapura, Cambridge Layout, Bangalore\n" +
                "\n" +
                "Services Offered: HaircutHair SpaBody MassageFoot Massage");

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
