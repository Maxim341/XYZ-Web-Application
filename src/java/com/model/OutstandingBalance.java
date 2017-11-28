/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Harri Renney
 */
public class OutstandingBalance {
    private float charge;
    private float payments;
    private float total;

    public OutstandingBalance(float charge, float payments, float total) {
        this.charge = charge;
        this.payments = payments;
        this.total = total;
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public float getPayments() {
        return payments;
    }

    public void setPayments(float payments) {
        this.payments = payments;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
