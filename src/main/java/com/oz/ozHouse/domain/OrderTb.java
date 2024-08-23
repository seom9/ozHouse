package com.oz.ozHouse.domain;

import java.util.ArrayList;
import java.util.List;

import com.oz.ozHouse.domain.OrderTb;
import com.oz.ozHouse.domain.common.Address;
import com.oz.ozHouse.domain.common.PhoneNumber;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderTb {
	
	@Id 
	@Column(name="orderNum")
    private Long oNum;				//주문 코드 :
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memberNum")
    private Member member;			//구매자 정보
    

    @OneToMany(mappedBy = "orderTb", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProInform> orderItems = new ArrayList<>();		//구매 상품
    
    @OneToMany(mappedBy = "orderTb", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserCoupon> useCoupons = new ArrayList<>();
    
    private int oDispoint;			//사용 포인트 금액 (양수 : 사용 / 음수 : 가현)
    
    private int oPrice;				//최종 상품 주문 금액
    
    private String oName;			// 배송 받을 사람 이름
    
    @Embedded						
    private PhoneNumber oHp;		// 배송 받을 사람 핸드폰
    
    @Embedded	
    private Address oAddress;		// 배송 받을 사람 주소지
    
    private String oComment;

    private String oDelnow;			// 배송 상태
	
    private String oLike;			// 주문 상태
   
    private String oCanceldate;		// 주문 취소일
    
    private String regDate;			// 주문일
    
    public void setList(List<ProInform> orderItems, List<UserCoupon> useCoupons) {
        this.orderItems = new ArrayList<>();
        this.useCoupons = new ArrayList<>();
        if (orderItems != null) {
            this.orderItems.addAll(orderItems);
        }
        if (useCoupons != null) {
            this.useCoupons.addAll(useCoupons);
        }
    }
    
    public void setONum(long oNum, String oLike, String oCanceldate) {
    	this.oNum = oNum;
    	this.oLike = oLike;
    	this.oCanceldate = oCanceldate;
    }
    
}