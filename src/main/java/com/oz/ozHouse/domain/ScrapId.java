package com.oz.ozHouse.domain;

import java.io.Serializable;

public class ScrapId implements Serializable{
    private int member;
    private int product;

    public ScrapId(){}
    public ScrapId(int member, int product){
        super();
        this.member = member;
        this.product = product;
    }
}

