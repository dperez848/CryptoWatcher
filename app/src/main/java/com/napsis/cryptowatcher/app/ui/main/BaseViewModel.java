package com.napsis.cryptowatcher.app.ui.main;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Daniela Perez danielaperez@kogimobile.com on 2/5/18.
 */

public abstract class BaseViewModel extends ViewModel {

    public static final String TAG = BaseViewModel.class.getSimpleName();

    private CompositeDisposable compositeDisposable;

    public BaseViewModel() {
        compositeDisposable = new CompositeDisposable();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared()");
        compositeDisposable.clear();
    }
}
