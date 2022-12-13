package com.example.muscle_studio_100;

public class Offer {

    String subscription_type , bill ;

    public Offer(String subscription_type, String bill) {
        this.subscription_type = subscription_type;
        this.bill = bill;
    }

    public String getSubscription_type() {
        return subscription_type;
    }

    public void setSubscription_type(String subscription_type) {
        this.subscription_type = subscription_type;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }
}
