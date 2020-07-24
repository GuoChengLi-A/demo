package com.shunteng.po;

import java.io.Serializable;

/**
 * product
 * @author 
 */
public class Product implements Serializable {
    private Integer id;

    private Integer quantity;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}