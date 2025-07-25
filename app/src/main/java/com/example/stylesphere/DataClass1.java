package com.example.stylesphere;

public class DataClass1 {
    private String username;
    private String phoneNumber;
    private String email;
    private String address; // Add address field
    private Booking booking;

    public DataClass1() {
        // Default constructor required for calls to DataSnapshot.getValue(DataClass1.class)
    }

    public DataClass1(String username, String phoneNumber, String email, String address) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public static class Booking {
        private String username;
        private String phoneNumber;
        private String email;
        private String address; // Add address field
        private String serviceName;
        private String paymentOption;

        public Booking(String s, String phoneNumber, String toString, String string, String address, String paymentOption, String price) {
            // Default constructor required for calls to DataSnapshot.getValue(DataClass1.Booking.class)
        }

        public Booking(String username, String phoneNumber, String email, String address, String serviceName, String paymentOption) {
            this.username = username;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.address = address;
            this.serviceName = serviceName;
            this.paymentOption = paymentOption;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getPaymentOption() {
            return paymentOption;
        }

        public void setPaymentOption(String paymentOption) {
            this.paymentOption = paymentOption;
        }
    }
}
