package com.napsis.cryptowatcher.data.managers.remote;


import com.napsis.cryptowatcher.data.managers.remote.responses.ResponseCurrency;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServiceInterface {

    @GET("v2/prices/{pair}/buy")
    Single<ResponseCurrency> getCurrencyBuy(@Path("pair") String pair);

    @GET("v2/prices/{pair}/sell")
    Single<ResponseCurrency> getCurrencySell(@Path("pair") String pair);
}
