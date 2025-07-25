package com.example.stylesphere;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HydSalon extends AppCompatActivity {

    private ListView addressListView;
    private AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyd_salon);

        addressListView = findViewById(R.id.addressListView5);
        List<String> mumbaiAddresses = new ArrayList<>();
        mumbaiAddresses.add("Call: +91 9247200375\n" +
                "\n" +
                "Name :The Salon\n"+
                "Timing: 10:00 am - 8:00 pm \n" +
                "Address: 18-2-456, Road No. 4, Banjara Hills, Hyderabad - 500034\n");

        mumbaiAddresses.add("Call: +91 9640000103\n" +
                "\n" +
                "Name :Salon Dear\n"+
                "Timing: 11:00 am - 8:30 pm\n" +
                "Address: Plot Number:102, Beside Deccan Grameena. Bank, Raghala Enclaves,Sahara Road, L B Nagar-Hyderabad, Hyderabad - 500074\n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +91 (040)67116641\n" +
                "\n" +
                "Name :Naturals Family Salon\n"+
                "Timing: 11:00 am - 8:30 pm\n" +
                "Address: No. 1/8/131-143, Karan Residency, Sindhi Colony,Near Paradise, Penderghast Road, Hyderabad - 500003\n" +
                "\n" +
                "Highlights: Wifi Available\n" +
                "\n" +
                "Services Offered: Keratin\n" +
                "\n" +
                " ");
        mumbaiAddresses.add("Call: +91 76800 20493\n\n" +
                "\n" +
                "Name :Naturals Family Salon & Spa\n"+
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address: Plot No 8-1-363/44/1, 2nd Floor, Opposite To Prime Meridian Function Hall,Deluxe Colony, Toli Chowki, Hyderabad - 500008\n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +91 99287 95959\n" +
                "\n" +
                "Name :Lucas Salon And Academy\n"+
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address:  Plot No 214,Surya Laxmi Complex, Above Andhra Bank,Near Kalyan Nagar, Sanjeeva Reddy Nagar, Hyderabad - 500038 \n" +
                "\n" +
                "Services Offered: Haircut");

        mumbaiAddresses.add("Call: +91 91422 91234\n" +
                "\n" +
                "Name :Loreal Professional Belle N Beau Family Salon\n"+
                "Timing: 10:00 am - 9:00 pm\n" +
                "Address: Near Minerva Coffee Shop, Himayat Nagar, Hyderabad - 500029\n");

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
