package com.napsis.cryptowatcher.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Daniela Perez danielaperez@kogimobile.com on 2/5/18.
 */

public class CurrencyCombo {

    private Currency btcSell;
    private Currency ethSell;
    private Currency bchSell;
    private Currency ltcSell;
    private Currency btcBuy;
    private Currency ethBuy;
    private Currency bchBuy;
    private Currency ltcBuy;


    public CurrencyCombo(Currency btcSell, Currency ethSell,
                         Currency bchSell, Currency ltcSell,
                         Currency btcBuy, Currency ethBuy,
                         Currency bchBuy, Currency ltcBuy) {
        this.btcSell = btcSell;
        this.ethSell = ethSell;
        this.bchSell = bchSell;
        this.ltcSell = ltcSell;
        this.btcBuy = btcBuy;
        this.ethBuy = ethBuy;
        this.bchBuy = bchBuy;
        this.ltcBuy = ltcBuy;
    }

    public Currency getBtcSell() {
        return btcSell;
    }

    public void setBtcSell(Currency btcSell) {
        this.btcSell = btcSell;
    }

    public Currency getEthSell() {
        return ethSell;
    }

    public void setEthSell(Currency ethSell) {
        this.ethSell = ethSell;
    }

    public Currency getBchSell() {
        return bchSell;
    }

    public void setBchSell(Currency bchSell) {
        this.bchSell = bchSell;
    }

    public Currency getLtcSell() {
        return ltcSell;
    }

    public void setLtcSell(Currency ltcSell) {
        this.ltcSell = ltcSell;
    }

    public Currency getBtcBuy() {
        return btcBuy;
    }

    public void setBtcBuy(Currency btcBuy) {
        this.btcBuy = btcBuy;
    }

    public Currency getEthBuy() {
        return ethBuy;
    }

    public void setEthBuy(Currency ethBuy) {
        this.ethBuy = ethBuy;
    }

    public Currency getBchBuy() {
        return bchBuy;
    }

    public void setBchBuy(Currency bchBuy) {
        this.bchBuy = bchBuy;
    }

    public Currency getLtcBuy() {
        return ltcBuy;
    }

    public void setLtcBuy(Currency ltcBuy) {
        this.ltcBuy = ltcBuy;
    }
}
