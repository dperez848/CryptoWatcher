package com.napsis.cryptowatcher.app;

import android.app.Application;

import com.kogimobile.android.baselibrary.app.base.BaseApp;

import timber.log.Timber;

/**
 * @author Daniela Perez danielaperez@kogimobile.com on 2/5/18.
 */

public class App extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        initTimber();
    }

    private void initTimber(){
        Timber.plant(
                new Timber.DebugTree() {
                    // Add the line number to the tag.
                    @Override
                    protected String createStackElementTag(StackTraceElement element) {
                        return super.createStackElementTag(element) + ':' + element.getLineNumber();
                    }
                });
    }
}
