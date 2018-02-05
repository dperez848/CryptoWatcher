package com.napsis.cryptowatcher.data.repository.currency;

import android.support.annotation.NonNull;

import com.napsis.cryptowatcher.data.models.CurrencyCombo;

import io.reactivex.Single;

public class RepositoryCurrency implements RepositoryCurrencyDataSource {

    private static RepositoryCurrency instance = null;
    private static RestCurrencySource sourceRest;

    @NonNull
    public static RepositoryCurrency newInstance() {
        if (instance == null) {
            instance = new RepositoryCurrency();
        }
        return instance;
    }

    @Override
    public Single<CurrencyCombo> getAll( ) {
        return getRestSource().getAll();
    }


    private RestCurrencySource getRestSource(){
        if(sourceRest == null){
            sourceRest = RestCurrencySource.newInstance();
        }
        return sourceRest;
    }

}
