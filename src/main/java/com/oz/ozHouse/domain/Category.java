package com.oz.ozHouse.domain;

import lombok.Getter;

@Getter
public enum Category {
    LIVING_ROOM_FURNITURE(1, "1001", "거실 가구"),
    BEDROOM_FURNITURE(2, "1002", "침실 가구"),
    KITCHEN_FURNITURE(3, "1003", "주방 가구"),
    LIGHTING(4, "1004", "조명"),
    HOME_DECOR(5, "1005", "홈데코"),
    PET_SUPPLIES(6, "1006", "애견 용품");

	private final int categoryNum;
    private final String categoryCode;
    private final String categoryName;

    Category(int categoryNum, String categoryCode, String categoryName) {
    	this.categoryNum = categoryNum;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }
}
