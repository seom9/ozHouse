package com.oz.ozHouse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor 
public class ProInform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proInNum;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proNum") 
    private Product product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oNum")
    private OrderTb orderTb; 
    
    private int quantity;
    
    private String oRefund;
    
    private int realPrice;

	public void setOrderTb(OrderTb orderTb) {
		this.orderTb = orderTb;
	}
    

    
}
