package com.napsis.cryptowatcher.data.managers.remote;

import com.napsis.cryptowatcher.data.managers.baselibrary.rest.BaseService;
import com.napsis.cryptowatcher.data.managers.remote.responses.ResponseCurrency;
import com.napsis.cryptowatcher.data.models.Currency;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Julian Cardona on 11/12/14.
 */
public class RestManagerPublicService extends BaseService<ApiServiceInterface> {

    public Single<Currency> getCurrencyBuy(String pair){
        return getApiService()
                .getCurrencyBuy(pair)
                .map(new Function<ResponseCurrency, Currency>() {
                    @Override
                    public Currency apply(ResponseCurrency responseCurrency) throws Exception {
                        return responseCurrency.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Currency> getCurrencySell(String pair){
        return getApiService()
                .getCurrencySell(pair)
                .map(new Function<ResponseCurrency, Currency>() {
                    @Override
                    public Currency apply(ResponseCurrency responseCurrency) throws Exception {
                        return responseCurrency.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
