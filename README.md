# 🧸 Toysrus_Clone (Back-End)
![7W_cloneCoding_tosrus_big](https://user-images.githubusercontent.com/87135478/146631765-eb519ec3-86aa-4788-8813-be02bc1fd666.jpg)


# 🗂 Summary
**항해99 4기, 클론코딩 주차**  
> \* Clone 대상 사이트 : [LOTTE Mart - Toysrus](http://toysrus.lottemart.com/)  
> \* Clone 페이지 : 로그인, 회원가입, 메인, 상품 상세, 장바구니  
> \* Clone 기능 : 로그인, 회원가입, 상품 노출, 상품 상세 조회, 상품 인기 순위, 장바구니 저장, 장바구니 조회  
  
- [\[사이트 바로가기\]](http://toysrus-clone-frontend.s3-website.ap-northeast-2.amazonaws.com/)  
- [\[시연영상 구경하기\]](https://youtu.be/xMYTOBW1igw)  

<br />

# 👥 멤버
- Back-end: [이한울](https://github.com/goodn911), [오규화](https://github.com/59-devv)
- Front-end: [김자운](https://github.com/jawoon816), [서민지](https://github.com/ireneeming)
- [\[Front-End Github\]](https://github.com/ireneeming/toysrusClone_FE)
<br />

# 🗓 프로젝트 기간
- 2021년 12월 13일 ~ 2021년 12월 18일 (6일 간)  
![readme_img1](https://user-images.githubusercontent.com/87135478/146631979-f7e5ad4e-43b8-4340-b9b4-70aa5cd48e3d.jpg)


<br />

# 🗺 ER Diagram
![스크린샷 2021-12-18 14 27 18](https://user-images.githubusercontent.com/87135478/146630402-4b82dedd-e90b-412d-b0cf-6305f28c93d4.png)



<br />

# ⚙️ 기술 스택

### Back-End

<div>
  <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white">
  <img src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
  <img src="https://img.shields.io/badge/swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black">
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
  <img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=AmazonAWS&logoColor=white">
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">

</div>  

### Front-End

<div>
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
  <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black">
  <img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white">
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
  <img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=AmazonAWS&logoColor=white">
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">  
  
</div>

<br />

# 📌 API 명세서

- 연애의 참견 API
    
    | 페이지 | 기능 | Method | URL | Request | Response |
    | --- | --- | --- | --- | --- | --- |
    | 회원정보 | 회원가입 | POST | /api/auth/signup | \{<br/>"name": "이한울",<br/>"username": "slkdglje",<br/>"domain": "naver.com",<br/>"password": "1234alsd",<br/>"passwordCheck": "1234alsd",<br/>"phone": "01012345678",<br/>"address": "서울 송파구 제2롯데"<br/>} | {<br/>result: "회원가입 성공"<br/>} | 
    |  | 로그인 | POST | /api/auth/login | {<br/>"username":"slkdglje@naver.com",<br/>"password":"1234alsd"<br/>} | {<br/>headers: { <br/> Authorization:<br/> token }<br/>} | 
    | 공통 | 로그인 정보 불러오기 | GET | /api/auth | { "Authorization" : token } | {<br/>result: "success",<br/>message: "로그인성공",<br/>username: "홍길동"<br/>} |    
    |  | 인기 순위 | GET | /api/item/ranking |  | {<br/>result: [ <br/>{<br/>itemName: "헬로카봇"<br/>},<br/>{<br/>itemName: "피카츄"<br/>}<br/>} |
    | 메인페이지 | 아이템리스트 | GET | /api/item?page={pageNo}&size={sieNo} |  | {<br/>result:  {<br/>timeLimitProducts: [<br/>{<br/>itemId : "1",<br/>itemName: "상품명",<br/>thumbnail : "이미지URL",<br/>price: "50000000원",<br/>discount: 25%,<br/>description: "설명"<br/>},<br/>....<br/>]<br/><br/>christmasProducts: [<br/>{<br/>itemId : "2",<br/>itemName: "상품명",<br/>thumbnail : "이미지URL",<br/>price: "50000000원"<br/>},<br/>....<br/>]<br/><br/>hotProducts: [<br/>{<br/>itemId : "3",<br/>itemName: "상품명",<br/>thumbnail : "이미지URL",<br/>price: "50000000원"<br/>},<br/>.....<br/>]<br/><br/>recommendProducts: {<br/>content: [<br/>{<br/>itemId : "4",<br/>itemName: "상품명",<br/>thumbnail : "이미지URL",<br/>price: "50000000원"<br/>},<br/>....<br/>]<br/>} |
    | 상세페이지 | item불러오기 | GET | /api/item/{itemId} |  | {<br/>result: <br/>{<br/>itemId : "1",<br/>itemName: "상품명",<br/>price: "50000000원",<br/>discount: 25%,<br/>thumbnail : "이미지URL",<br/>imgDetail: "상품Detail 이미지 URL"<br/>}<br/>} |
    |  | 장바구니에 저장 | POST | /api/cart | {<br/>itemId: "1",<br/>count: "2"<br/>} |  |
    | 장바구니 | 장바구니 보기 | GET | /api/cart |  | {<br/>result: {<br/>userInfo :<br/>{<br/>userId : "1",<br/>name: "홍길동",<br/>address: "서울시"<br/>},<br/><br/>items : [<br/>{<br/>itemId: "1",<br/>itemName: "상품명",<br/>price: "500000000원",<br/>count: "3",<br/>},<br/>{<br/>itemId: "4",<br/>itemName: "상품명",<br/>price: "500000000원",<br/>count: "2",<br/>},<br/>....<br/>]<br/>} |
  

<br />

# 🔑 페이지 설명

* **로그인 페이지**  
  \- 가입된 회원의 정보와 일치하는지 확인 후, 일치할 경우 로그인 성공  
  
* **회원가입 페이지**  
  \- 이름 : 사용자의 이름을 입력받음  
  \- 아이디 : Email주소의 @ 이전에 해당하는 아이디를 입력받음  
  \- 도메인 : 어떤 Email 도메인을 사용하는지를 입력받음  
  \- 비밀번호 : 영어 대소문자, 숫자, 특수문자 혼합 8-15자  
  \- 비밀번호 확인 : 위 비밀번호와 일치하는지 확인  
  \- 휴대폰번호 : 숫자만 입력 가능 / 11자 이상 입력 불가  
  \- 주소 : 사용자의 주소(배송지)를 입력받음  
  
* **메인 페이지**  
  \- 상품 조회 : 영역별 상품을 조회하고, 해당 상품을 클릭 시 상품 상세정보 페이지로 이동  
  \- 상품 랭킹 : 인기 상품을 최대 30개까지 순위별로 보여줌  
  
* **상품 상세정보**  
  \- 상품의 상세 정보를 조회할 수 있는 페이지  
  \- 상품의 수량을 선택하여 장바구니에 담을 수 있는 기능 제공  
  
* **장바구니**  
  \- 로그인 한 유저가 현재까지 장바구니에 담은 상품을 조회할 수 있음  

<br />

# 💡 Trouble Shooting

<details>
  <summary> 1. 데이터 크롤링 관련 이슈 </summary>
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;(1) Toysrus 사이트의 상품은 Jsoup으로 크롤링이 어려움 (데이터가 동적으로 화면에 출력되는 형식으로 보임)<br/>  
    &nbsp;&nbsp;&nbsp;&nbsp;(2) Jsoup 대신 Selenium을 사용하였으나, 크롤링 속도 문제로 어려움을 겪음<br/>  
    &nbsp;&nbsp;&nbsp;&nbsp;(3) 필요한 상품정보를 동일하게 크롤링 할 수 있는 사이트를 검색하여, SSG 사이트에서 상품을 크롤링 (Jsoup)<br/>  
  </div>
</details>

<details>
  <summary> 2. 무한스크롤 관련 </summary>
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;(1) 무한스크롤을 위해 상품정보를 Page<Item> 형식으로 클라이언트에 전송 <br/>  
    &nbsp;&nbsp;&nbsp;&nbsp;(2) 하지만, 클라이언트에서 원하는 형식으로 데이터를 보내기 위해서는 Dto를 만들어야 할 필요성을 인식 <br/>  
    &nbsp;&nbsp;&nbsp;&nbsp;(3) Page<Item>을 Page<ItemDto> 형식으로 변경하여, 이슈 해결 <br/>  
    <div class="colorscripter-code" style="color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important; position:relative !important;overflow:auto"><table class="colorscripter-code-table" style="margin:0;padding:0;border:none;background-color:#fafafa;border-radius:4px;" cellspacing="0" cellpadding="0"><tr><td style="padding:6px;border-right:2px solid #e5e5e5"><div style="margin:0;padding:0;word-break:normal;text-align:right;color:#666;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="line-height:130%">1</div><div style="line-height:130%">2</div><div style="line-height:130%">3</div><div style="line-height:130%">4</div><div style="line-height:130%">5</div><div style="line-height:130%">6</div><div style="line-height:130%">7</div><div style="line-height:130%">8</div><div style="line-height:130%">9</div><div style="line-height:130%">10</div><div style="line-height:130%">11</div><div style="line-height:130%">12</div><div style="line-height:130%">13</div><div style="line-height:130%">14</div></div></td><td style="padding:6px 0;text-align:left"><div style="margin:0;padding:0;color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="padding:0 6px; white-space:pre; line-height:130%">Page<span style="color:#0086b3"></span><span style="color:#a71d5d">&lt;</span>Item<span style="color:#0086b3"></span><span style="color:#a71d5d">&gt;</span>&nbsp;findPage&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;itemRepository.findAll(pageable);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#999999">//&nbsp;Pageable&nbsp;형식을&nbsp;Dto로&nbsp;바꾸는&nbsp;로직</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">Page<span style="color:#0086b3"></span><span style="color:#a71d5d">&lt;</span>RecommendItemDto<span style="color:#0086b3"></span><span style="color:#a71d5d">&gt;</span>&nbsp;dtoPage&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;findPage.map(<span style="color:#a71d5d">new</span>&nbsp;Function<span style="color:#0086b3"></span><span style="color:#a71d5d">&lt;</span>Item,&nbsp;RecommendItemDto<span style="color:#0086b3"></span><span style="color:#a71d5d">&gt;</span>()&nbsp;{</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;@Override</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#a71d5d">public</span>&nbsp;RecommendItemDto&nbsp;apply(Item&nbsp;item)&nbsp;{</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RecommendItemDto&nbsp;dto&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;<span style="color:#a71d5d">new</span>&nbsp;RecommendItemDto();</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dto.setItemId(item.getId());</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dto.setPrice(item.getPrice());</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dto.setThumbnail(item.getThumbnail());</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dto.setItemName(item.getItemName());</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#a71d5d">return</span>&nbsp;dto;</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;});</div></div></td></tr></table></div>
  </div></details>
  
<details>
  <summary> 3. CORS 이슈 </summary>
  <div>
  &nbsp;&nbsp;&nbsp;&nbsp;(1) 구글링을 통해 여러 방법으로 적용해보았으나, 지속적으로 CORS 이슈 발생<br/>  
  &nbsp;&nbsp;&nbsp;&nbsp;(2) 프로젝트 재생성을 통해 이슈 해결 🙉 <br/>  
  </div>
</details>

<details>
  <summary> 4. 로그인이 필요하지 않은 페이지에서, 로그인을 요청하는 이슈 </summary>
  <div>
  &nbsp;&nbsp;&nbsp;&nbsp;(1) JWT 토큰을 검사하지 않도록 PATH 설정을 하였으나, 정상적으로 동작하지 않았음<br/>  
  &nbsp;&nbsp;&nbsp;&nbsp;(2) PATH 작성 시, '띄어쓰기'를 제거함으로 이슈 1차 해결 🙉 <br/>  
  &nbsp;&nbsp;&nbsp;&nbsp;(3) 일부 로직에서 'FormLoginFilter'로 로그인 요청을 하는 상황 발생<br/>  
  &nbsp;&nbsp;&nbsp;&nbsp;(4) 기존 Spring Security의 Login 로직 대신, 직접 Login API 구현함으로 이슈 해결<br/>
  </div>
</details>
