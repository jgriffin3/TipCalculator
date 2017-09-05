package com.johndavidgriffin.tipcalculator;

/**
 * Created by johngriffin on 9/5/17.
 */

public class TipCalculator
{
    private Float bill;
    private Float tipPercent;
    private Float tipAmount;
    private Float total;

    public Float getBill() {
        return bill;
    }

    public void setBill(Float bill) {
        this.bill = bill;
    }

    public Float getTipPercent() {
        return tipPercent;
    }

    public void setTipPercent(Float tipPercent) {
        this.tipPercent = tipPercent;
        setTipAmount((Float) bill * (this.tipPercent / 100));
    }

    public Float getTotal() {
        calculateTotal();
        return total;
    }

    public Float getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(Float tipAmount) {
        this.tipAmount = tipAmount;
    }

    private void calculateTotal()
    {
        total = bill + tipAmount;
    }
}
