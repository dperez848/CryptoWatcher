package com.napsis.cryptowatcher.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Daniela Perez danielaperez@kogimobile.com on 2/5/18.
 */

public class Currency {

    public static final int USD = 0;
    public static final int EUR = 1;
    public static final int GBP = 2;


    @Expose
    @SerializedName("amount")
    private String amount;
    @Expose
    @SerializedName("currency")
    private String currency;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
