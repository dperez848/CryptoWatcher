package com.napsis.cryptowatcher.data.repository.currency;

import com.napsis.cryptowatcher.data.models.Currency;
import com.napsis.cryptowatcher.data.models.CurrencyCombo;

import io.reactivex.Single;

/**
 * Created by Julian Cardona on 1/25/17.
 */

public interface RepositoryCurrencyDataSource {

    Single<CurrencyCombo> getAll(int type);


}
