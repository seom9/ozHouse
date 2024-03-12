### 프로젝트명 
ozHouse

### 팀원
남가현, 이문주, 김서아, 최지영

### 개발환경
Java 21, STS4, Gradle, GitHub, MySQL 8.0, AWS

### 기술 스택
**[Back-end]**
**Spring Data JPA**, **Spring Security**, JPQL, MyBatis, QueryDSL, WebSocket, Spring qaurtz, OAuth2.0, JavaMail API, AWS S3 <br>
**[Front-end]**
JavaScript, JSP, html, css, Ajax

### 프로젝트 소개
'오늘의 집'과 같은 **종합 쇼핑몰**을 모티브로 하여 사용자로 하여금 효율적인 가구 쇼핑을 할 수 있도록 설계하였습니다. 뿐만 아니라 **블로그, 중고 거래 플랫폼**을 추가하여 사용자가 사이트에 흥미를 느낄 수 있도록 하였습니다.

### 프로잭트 설계

<img width="446" alt="image" src="https://github.com/gahyunseoul/ozHouse/assets/123463416/1509b880-7676-47e6-b917-669f0529c747">

**설계의 주안점**
- 객체중심적인 개발과 장기적인 유지보수를 위한 JPA 사용
- Spring Security 와 OAuth2.0 을 통한 회원 가입 및 로그인, 권한 부여
- REST API URL 규칙을 따른 구성으로 자원 명시 후 HTTP Method 를 통한 CRUD 경험
- 유지보수 경험을 목적으로 레거시 코드 수정, 코드 가독성 향상 목표
- Setter 메서드 및 @Data 지양, builder 패턴과 생성자로 Entity 와 DTO 객체 생성

**프로젝트 메인 페이지**

<img width="420" alt="image" src="https://github.com/gahyunseoul/ozHouse/assets/123463416/077d280c-adef-4ba1-91e4-b5aee9223298">

**개발 & 협업 방식**
- 40일만에 프로젝트의 유지보수를 빠르게 구현해야 하였기 때문에 **애자일 방식**을 채택하였습니다.
- 팀원들과 매일 아침 모여 15분의 **스크럼 회의**를 하였고, 오늘의 목표, 목표 달성 내용, 남은 구현 페이지 혹은 발생한 이슈를 공유하였습니다. 결과적으로 빠른 시간 내에 목표한 내용을 달성할 수 있었습니다.
- 노션을 통한 협업 및 [전사 목표 관리](https://www.notion.so/Oz-883d1cad929a48a0b5ff7fe9b0ee18dd?pvs=21)를 진행하였습니다.

**주요 ERD**

<img width="365" alt="image" src="https://github.com/gahyunseoul/ozHouse/assets/123463416/5a794811-65f7-4cec-99f2-d68b169fa765">
