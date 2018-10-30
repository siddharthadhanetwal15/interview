package com.sapient.model;

/**
 * Created by dhanetwa on 8/11/2018.
 */
public class DetailInput extends DetailOutput{
    String currency;
    String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "DetailInput{" +
                "country='" + country + '\'' +
                ", currency='" + currency + '\'' +
                ", gender='" + gender + '\'' +
                ", amount=" + amount +
                ", city='" + city + '\'' +
                '}';
    }
}
