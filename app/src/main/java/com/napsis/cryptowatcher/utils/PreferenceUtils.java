package com.napsis.cryptowatcher.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.kogimobile.android.baselibrary.utils.StringUtils;
import com.napsis.cryptowatcher.app.App;
import com.napsis.cryptowatcher.data.models.Currency;

public class PreferenceUtils {


    private static final String PREF_CURRENCY = "PREF_CURRENCY";

    private static final String PREF_NOTIFICATION_VALUE = "PREF_NOTIFICATION_VALUE";
    private static final String PREF_NOTIFICATION_CURRENCY = "PREF_NOTIFICATION_CURRENCY";
    private static final String PREF_NOTIFICATION_TYPE = "PREF_NOTIFICATION_TYPE";

    private static final String PREF_NOTIFICATION_LOW_AVAILABLE_BTC = "PREF_NOTIFICATION_LOW_AVAILABLE_BTC";
    private static final String PREF_NOTIFICATION_HIGH_AVAILABLE_BTC = "PREF_NOTIFICATION_HIGH_AVAILABLE_BTC";

    private static final String PREF_NOTIFICATION_LOW_AVAILABLE_ETH = "PREF_NOTIFICATION_LOW_AVAILABLE_ETH";
    private static final String PREF_NOTIFICATION_HIGH_AVAILABLE_ETH = "PREF_NOTIFICATION_HIGH_AVAILABLE_ETH";

    private static final String PREF_NOTIFICATION_LOW_AVAILABLE_BCH = "PREF_NOTIFICATION_LOW_AVAILABLE_BCH";
    private static final String PREF_NOTIFICATION_HIGH_AVAILABLE_BCH = "PREF_NOTIFICATION_HIGH_AVAILABLE_BCH";

    private static final String PREF_NOTIFICATION_LOW_AVAILABLE_LTC = "PREF_NOTIFICATION_LOW_AVAILABLE_LTC";
    private static final String PREF_NOTIFICATION_HIGH_AVAILABLE_LTC = "PREF_NOTIFICATION_HIGH_AVAILABLE_LTC";

    public static void clearPreferences() {
        getPreferences(App.getGlobalContext()).edit().clear().apply();
    }

    PreferenceUtils() {
        throw new IllegalStateException("Utility class, please don't instantiate");
    }

    protected static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    protected static SharedPreferences.Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }

    public static void setCurrencyPreference(int type){
        getEditor(App.getGlobalContext()).putInt(PREF_CURRENCY, type).apply();
    }

    public static int getCurrencyPreference(){
        return getPreferences(App.getGlobalContext()).getInt(PREF_CURRENCY, 0);
    }

    public static void setPrefNotificationValue(int value){
        getEditor(App.getGlobalContext()).putInt(PREF_NOTIFICATION_VALUE, value).apply();
    }

    public static int getPrefNotificationValue(){
        return getPreferences(App.getGlobalContext()).getInt(PREF_NOTIFICATION_VALUE, 0);
    }

    public static void setPrefNotificationCurrency(int value){
        getEditor(App.getGlobalContext()).putInt(PREF_NOTIFICATION_CURRENCY, value).apply();
    }

    public static int getPrefNotificationCurrency(){
        return getPreferences(App.getGlobalContext()).getInt(PREF_NOTIFICATION_CURRENCY, 0);
    }

    public static void setPrefNotificationType(int value){
        getEditor(App.getGlobalContext()).putInt(PREF_NOTIFICATION_TYPE, value).apply();
    }

    public static int getPrefNotificationType(){
        return getPreferences(App.getGlobalContext()).getInt(PREF_NOTIFICATION_TYPE, 0);
    }

    public static void setPrefNotificationLowBtc(boolean value){
        getEditor(App.getGlobalContext()).putBoolean(PREF_NOTIFICATION_LOW_AVAILABLE_BTC, value).apply();
    }

    public static boolean setPrefNotificationLowBtc(){
        return getPreferences(App.getGlobalContext()).getBoolean(PREF_NOTIFICATION_LOW_AVAILABLE_BTC, false);
    }

    public static void setPrefNotificationLowEth(boolean value){
        getEditor(App.getGlobalContext()).putBoolean(PREF_NOTIFICATION_LOW_AVAILABLE_ETH, value).apply();
    }

    public static boolean setPrefNotificationLowEth(){
        return getPreferences(App.getGlobalContext()).getBoolean(PREF_NOTIFICATION_LOW_AVAILABLE_ETH, false);
    }
    public static void setPrefNotificationLowBch(boolean value){
        getEditor(App.getGlobalContext()).putBoolean(PREF_NOTIFICATION_LOW_AVAILABLE_BCH, value).apply();
    }

    public static boolean setPrefNotificationLowBch(){
        return getPreferences(App.getGlobalContext()).getBoolean(PREF_NOTIFICATION_LOW_AVAILABLE_BCH, false);
    }
    public static void setPrefNotificationLowLtc(boolean value){
        getEditor(App.getGlobalContext()).putBoolean(PREF_NOTIFICATION_LOW_AVAILABLE_LTC, value).apply();
    }

    public static boolean setPrefNotificationLowLtc(){
        return getPreferences(App.getGlobalContext()).getBoolean(PREF_NOTIFICATION_LOW_AVAILABLE_LTC, false);
    }

    public static void setPrefNotificationHighBtc(boolean value){
        getEditor(App.getGlobalContext()).putBoolean(PREF_NOTIFICATION_HIGH_AVAILABLE_BTC, value).apply();
    }

    public static boolean setPrefNotificationHighBtc(){
        return getPreferences(App.getGlobalContext()).getBoolean(PREF_NOTIFICATION_HIGH_AVAILABLE_BTC, false);
    }

    public static void setPrefNotificationHighEth(boolean value){
        getEditor(App.getGlobalContext()).putBoolean(PREF_NOTIFICATION_HIGH_AVAILABLE_ETH, value).apply();
    }

    public static boolean setPrefNotificationHighEth(){
        return getPreferences(App.getGlobalContext()).getBoolean(PREF_NOTIFICATION_HIGH_AVAILABLE_ETH, false);
    }
    public static void setPrefNotificationHighBch(boolean value){
        getEditor(App.getGlobalContext()).putBoolean(PREF_NOTIFICATION_HIGH_AVAILABLE_BCH, value).apply();
    }

    public static boolean setPrefNotificationHighBch(){
        return getPreferences(App.getGlobalContext()).getBoolean(PREF_NOTIFICATION_HIGH_AVAILABLE_BCH, false);
    }
    public static void setPrefNotificationHighLtc(boolean value){
        getEditor(App.getGlobalContext()).putBoolean(PREF_NOTIFICATION_HIGH_AVAILABLE_LTC, value).apply();
    }

    public static boolean setPrefNotificationHighLtc(){
        return getPreferences(App.getGlobalContext()).getBoolean(PREF_NOTIFICATION_HIGH_AVAILABLE_LTC, false);
    }
}
