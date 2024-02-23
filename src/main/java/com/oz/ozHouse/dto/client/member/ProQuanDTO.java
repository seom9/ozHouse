package com.oz.ozHouse.dto.client.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProQuanDTO {
    private ClientProductDTO productDTO;
    private int quantity;
}
