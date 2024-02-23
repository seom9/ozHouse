package com.oz.ozHouse.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor  
public class ImageDTO {
    private String proImg;
    private String proImgPro;
    private String proImageChange;
    private String proImageProChange;
    private String encodeImage;
}
