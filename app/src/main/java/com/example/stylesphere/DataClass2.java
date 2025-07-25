package com.example.stylesphere;

public class DataClass2 {

    // Ensure that the Booking class matches your Firebase data structure
    public static class Booking {
        private String username;
        private String email;
        private String serviceName;
        private String address;
        private String phone; // Added phoneNumber field

        // Default constructor required for calls to DataSnapshot.getValue(DataClass2.Booking.class)
        public Booking() {
        }

        public Booking(String username, String email, String serviceName, String address, String phone) {
            this.username = username;
            this.email = email;
            this.serviceName = serviceName;
            this.address = address;
            this.phone = phone;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public String getServiceName() {
            return serviceName;
        }

        public String getAddress() {
            return address;
        }

        public String getPhone() {
            return phone;
        }
    }
}