package com.oz.ozHouse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    private int proQuanNum;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proNum")
    private Product product;
    
    private int quantity;
    
    private String oRefund;
}
