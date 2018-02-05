package com.napsis.cryptowatcher.data.managers.remote.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.napsis.cryptowatcher.data.models.Currency;

/**
 * @author Daniela Perez danielaperez@kogimobile.com on 2/5/18.
 */

public class ResponseCurrency {

    @Expose
    @SerializedName("data")
    private Currency data;

    public Currency getData() {
        return data;
    }

    public void setData(Currency data) {
        this.data = data;
    }
}
