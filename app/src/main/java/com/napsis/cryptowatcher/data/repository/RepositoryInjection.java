package com.napsis.cryptowatcher.data.repository;

import com.napsis.cryptowatcher.data.repository.currency.RepositoryCurrency;

/**
 * Created by Julian Cardona on 2/15/17.
 */

public class RepositoryInjection {

    public static RepositoryCurrency getRepositoryCurrency() {
        return RepositoryCurrency.newInstance();
    }

}
