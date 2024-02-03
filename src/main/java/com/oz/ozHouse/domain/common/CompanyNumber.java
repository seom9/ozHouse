<<<<<<< HEAD:src/main/java/com/oz/ozHouse/domain/common/CompanyNumber.java
package com.oz.ozHouse.domain.common;
=======
package com.oz.ozHouse.domain.member;
>>>>>>> ee6a3d10e33b74da7f6a650f5f3d0378ae56172a:src/main/java/com/oz/ozHouse/domain/member/CompanyNumber.java

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor   //기본 생성자 자동 생성
@AllArgsConstructor  //필드의 모든 값을 초기화하는 생성자 자동 생성
@Getter
public class CompanyNumber {
    private String merComnum1;
    private String merComnum2;
    private String merComnum3;
}
