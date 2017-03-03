package com.moze.model;

public class Cart extends CartKey {

    private Object ilist;

    public Object getIlist() {
        return ilist;
    }

    public void setIlist(Object ilist) {
        this.ilist = ilist;
    }

    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}