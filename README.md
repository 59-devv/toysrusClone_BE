# ๐งธ Toysrus_Clone (Back-End)
![7W_cloneCoding_tosrus_big](https://user-images.githubusercontent.com/87135478/146631765-eb519ec3-86aa-4788-8813-be02bc1fd666.jpg)


# ๐ Summary
**ํญํด99 4๊ธฐ, ํด๋ก ์ฝ๋ฉ ์ฃผ์ฐจ**  
> \* Clone ๋์ ์ฌ์ดํธ : [LOTTE Mart - Toysrus](http://toysrus.lottemart.com/)  
> \* Clone ํ์ด์ง : ๋ก๊ทธ์ธ, ํ์๊ฐ์, ๋ฉ์ธ, ์ํ ์์ธ, ์ฅ๋ฐ๊ตฌ๋  
> \* Clone ๊ธฐ๋ฅ : ๋ก๊ทธ์ธ, ํ์๊ฐ์, ์ํ ๋ธ์ถ, ์ํ ์์ธ ์กฐํ, ์ํ ์ธ๊ธฐ ์์, ์ฅ๋ฐ๊ตฌ๋ ์ ์ฅ, ์ฅ๋ฐ๊ตฌ๋ ์กฐํ  
  
- [\[์ฌ์ดํธ ๋ฐ๋ก๊ฐ๊ธฐ\]](http://toysrus-clone-frontend.s3-website.ap-northeast-2.amazonaws.com/)  
- [\[์์ฐ์์ ๊ตฌ๊ฒฝํ๊ธฐ\]](https://youtu.be/xMYTOBW1igw)  

<br />

# ๐ฅ ๋ฉค๋ฒ
- Back-end: [์ดํ์ธ](https://github.com/goodn911), [์ค๊ทํ](https://github.com/59-devv)
- Front-end: [๊น์์ด](https://github.com/jawoon816), [์๋ฏผ์ง](https://github.com/ireneeming)
- [\[Front-End Github\]](https://github.com/ireneeming/toysrusClone_FE)
<br />

# ๐ ํ๋ก์ ํธ ๊ธฐ๊ฐ
- 2021๋ 12์ 13์ผ ~ 2021๋ 12์ 18์ผ (6์ผ ๊ฐ)  
![readme_img1](https://user-images.githubusercontent.com/87135478/146631979-f7e5ad4e-43b8-4340-b9b4-70aa5cd48e3d.jpg)


<br />

# ๐บ ER Diagram
![แแณแแณแแตแซแแฃแบ 2021-12-18 14 27 18](https://user-images.githubusercontent.com/87135478/146630402-4b82dedd-e90b-412d-b0cf-6305f28c93d4.png)



<br />

# โ๏ธ ๊ธฐ์  ์คํ

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

# ๐ API ๋ช์ธ์

- ์ฐ์ ์ ์ฐธ๊ฒฌ API
    
    | ํ์ด์ง | ๊ธฐ๋ฅ | Method | URL | Request | Response |
    | --- | --- | --- | --- | --- | --- |
    | ํ์์ ๋ณด | ํ์๊ฐ์ | POST | /api/auth/signup | \{<br/>"name": "์ดํ์ธ",<br/>"username": "slkdglje",<br/>"domain": "naver.com",<br/>"password": "1234alsd",<br/>"passwordCheck": "1234alsd",<br/>"phone": "01012345678",<br/>"address": "์์ธ ์กํ๊ตฌ ์ 2๋กฏ๋ฐ"<br/>} | {<br/>result: "ํ์๊ฐ์ ์ฑ๊ณต"<br/>} | 
    |  | ๋ก๊ทธ์ธ | POST | /api/auth/login | {<br/>"username":"slkdglje@naver.com",<br/>"password":"1234alsd"<br/>} | {<br/>headers: { <br/> Authorization:<br/> token }<br/>} | 
    | ๊ณตํต | ๋ก๊ทธ์ธ ์ ๋ณด ๋ถ๋ฌ์ค๊ธฐ | GET | /api/auth | { "Authorization" : token } | {<br/>result: "success",<br/>message: "๋ก๊ทธ์ธ์ฑ๊ณต",<br/>username: "ํ๊ธธ๋"<br/>} |    
    |  | ์ธ๊ธฐ ์์ | GET | /api/item/ranking |  | {<br/>result: [ <br/>{<br/>itemName: "ํฌ๋ก์นด๋ด"<br/>},<br/>{<br/>itemName: "ํผ์นด์ธ"<br/>}<br/>} |
    | ๋ฉ์ธํ์ด์ง | ์์ดํ๋ฆฌ์คํธ | GET | /api/item?page={pageNo}&size={sieNo} |  | {<br/>result:  {<br/>timeLimitProducts: [<br/>{<br/>itemId : "1",<br/>itemName: "์ํ๋ช",<br/>thumbnail : "์ด๋ฏธ์งURL",<br/>price: "50000000์",<br/>discount: 25%,<br/>description: "์ค๋ช"<br/>},<br/>....<br/>]<br/><br/>christmasProducts: [<br/>{<br/>itemId : "2",<br/>itemName: "์ํ๋ช",<br/>thumbnail : "์ด๋ฏธ์งURL",<br/>price: "50000000์"<br/>},<br/>....<br/>]<br/><br/>hotProducts: [<br/>{<br/>itemId : "3",<br/>itemName: "์ํ๋ช",<br/>thumbnail : "์ด๋ฏธ์งURL",<br/>price: "50000000์"<br/>},<br/>.....<br/>]<br/><br/>recommendProducts: {<br/>content: [<br/>{<br/>itemId : "4",<br/>itemName: "์ํ๋ช",<br/>thumbnail : "์ด๋ฏธ์งURL",<br/>price: "50000000์"<br/>},<br/>....<br/>]<br/>} |
    | ์์ธํ์ด์ง | item๋ถ๋ฌ์ค๊ธฐ | GET | /api/item/{itemId} |  | {<br/>result: <br/>{<br/>itemId : "1",<br/>itemName: "์ํ๋ช",<br/>price: "50000000์",<br/>discount: 25%,<br/>thumbnail : "์ด๋ฏธ์งURL",<br/>imgDetail: "์ํDetail ์ด๋ฏธ์ง URL"<br/>}<br/>} |
    |  | ์ฅ๋ฐ๊ตฌ๋์ ์ ์ฅ | POST | /api/cart | {<br/>itemId: "1",<br/>count: "2"<br/>} |  |
    | ์ฅ๋ฐ๊ตฌ๋ | ์ฅ๋ฐ๊ตฌ๋ ๋ณด๊ธฐ | GET | /api/cart |  | {<br/>result: {<br/>userInfo :<br/>{<br/>userId : "1",<br/>name: "ํ๊ธธ๋",<br/>address: "์์ธ์"<br/>},<br/><br/>items : [<br/>{<br/>itemId: "1",<br/>itemName: "์ํ๋ช",<br/>price: "500000000์",<br/>count: "3",<br/>},<br/>{<br/>itemId: "4",<br/>itemName: "์ํ๋ช",<br/>price: "500000000์",<br/>count: "2",<br/>},<br/>....<br/>]<br/>} |
  

<br />

# ๐ ํ์ด์ง ์ค๋ช

* **๋ก๊ทธ์ธ ํ์ด์ง**  
  \- ๊ฐ์๋ ํ์์ ์ ๋ณด์ ์ผ์นํ๋์ง ํ์ธ ํ, ์ผ์นํ  ๊ฒฝ์ฐ ๋ก๊ทธ์ธ ์ฑ๊ณต  
  
* **ํ์๊ฐ์ ํ์ด์ง**  
  \- ์ด๋ฆ : ์ฌ์ฉ์์ ์ด๋ฆ์ ์๋ ฅ๋ฐ์  
  \- ์์ด๋ : Email์ฃผ์์ @ ์ด์ ์ ํด๋นํ๋ ์์ด๋๋ฅผ ์๋ ฅ๋ฐ์  
  \- ๋๋ฉ์ธ : ์ด๋ค Email ๋๋ฉ์ธ์ ์ฌ์ฉํ๋์ง๋ฅผ ์๋ ฅ๋ฐ์  
  \- ๋น๋ฐ๋ฒํธ : ์์ด ๋์๋ฌธ์, ์ซ์, ํน์๋ฌธ์ ํผํฉ 8-15์  
  \- ๋น๋ฐ๋ฒํธ ํ์ธ : ์ ๋น๋ฐ๋ฒํธ์ ์ผ์นํ๋์ง ํ์ธ  
  \- ํด๋ํฐ๋ฒํธ : ์ซ์๋ง ์๋ ฅ ๊ฐ๋ฅ / 11์ ์ด์ ์๋ ฅ ๋ถ๊ฐ  
  \- ์ฃผ์ : ์ฌ์ฉ์์ ์ฃผ์(๋ฐฐ์ก์ง)๋ฅผ ์๋ ฅ๋ฐ์  
  
* **๋ฉ์ธ ํ์ด์ง**  
  \- ์ํ ์กฐํ : ์์ญ๋ณ ์ํ์ ์กฐํํ๊ณ , ํด๋น ์ํ์ ํด๋ฆญ ์ ์ํ ์์ธ์ ๋ณด ํ์ด์ง๋ก ์ด๋  
  \- ์ํ ๋ญํน : ์ธ๊ธฐ ์ํ์ ์ต๋ 30๊ฐ๊น์ง ์์๋ณ๋ก ๋ณด์ฌ์ค  
  
* **์ํ ์์ธ์ ๋ณด**  
  \- ์ํ์ ์์ธ ์ ๋ณด๋ฅผ ์กฐํํ  ์ ์๋ ํ์ด์ง  
  \- ์ํ์ ์๋์ ์ ํํ์ฌ ์ฅ๋ฐ๊ตฌ๋์ ๋ด์ ์ ์๋ ๊ธฐ๋ฅ ์ ๊ณต  
  
* **์ฅ๋ฐ๊ตฌ๋**  
  \- ๋ก๊ทธ์ธ ํ ์ ์ ๊ฐ ํ์ฌ๊น์ง ์ฅ๋ฐ๊ตฌ๋์ ๋ด์ ์ํ์ ์กฐํํ  ์ ์์  

<br />

# ๐ก Trouble Shooting

<details>
  <summary> 1. ๋ฐ์ดํฐ ํฌ๋กค๋ง ๊ด๋ จ ์ด์ </summary>
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;(1) Toysrus ์ฌ์ดํธ์ ์ํ์ Jsoup์ผ๋ก ํฌ๋กค๋ง์ด ์ด๋ ค์ (๋ฐ์ดํฐ๊ฐ ๋์ ์ผ๋ก ํ๋ฉด์ ์ถ๋ ฅ๋๋ ํ์์ผ๋ก ๋ณด์)<br/>  
    &nbsp;&nbsp;&nbsp;&nbsp;(2) Jsoup ๋์  Selenium์ ์ฌ์ฉํ์์ผ๋, ํฌ๋กค๋ง ์๋ ๋ฌธ์ ๋ก ์ด๋ ค์์ ๊ฒช์<br/>  
    &nbsp;&nbsp;&nbsp;&nbsp;(3) ํ์ํ ์ํ์ ๋ณด๋ฅผ ๋์ผํ๊ฒ ํฌ๋กค๋ง ํ  ์ ์๋ ์ฌ์ดํธ๋ฅผ ๊ฒ์ํ์ฌ, SSG ์ฌ์ดํธ์์ ์ํ์ ํฌ๋กค๋ง (Jsoup)<br/>  
  </div>
</details>

<details>
  <summary> 2. ๋ฌดํ์คํฌ๋กค ๊ด๋ จ </summary>
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;(1) ๋ฌดํ์คํฌ๋กค์ ์ํด ์ํ์ ๋ณด๋ฅผ Page<Item> ํ์์ผ๋ก ํด๋ผ์ด์ธํธ์ ์ ์ก <br/>  
    &nbsp;&nbsp;&nbsp;&nbsp;(2) ํ์ง๋ง, ํด๋ผ์ด์ธํธ์์ ์ํ๋ ํ์์ผ๋ก ๋ฐ์ดํฐ๋ฅผ ๋ณด๋ด๊ธฐ ์ํด์๋ Dto๋ฅผ ๋ง๋ค์ด์ผ ํ  ํ์์ฑ์ ์ธ์ <br/>  
    &nbsp;&nbsp;&nbsp;&nbsp;(3) Page<Item>์ Page<ItemDto> ํ์์ผ๋ก ๋ณ๊ฒฝํ์ฌ, ์ด์ ํด๊ฒฐ <br/>  
    <div class="colorscripter-code" style="color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important; position:relative !important;overflow:auto"><table class="colorscripter-code-table" style="margin:0;padding:0;border:none;background-color:#fafafa;border-radius:4px;" cellspacing="0" cellpadding="0"><tr><td style="padding:6px;border-right:2px solid #e5e5e5"><div style="margin:0;padding:0;word-break:normal;text-align:right;color:#666;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="line-height:130%">1</div><div style="line-height:130%">2</div><div style="line-height:130%">3</div><div style="line-height:130%">4</div><div style="line-height:130%">5</div><div style="line-height:130%">6</div><div style="line-height:130%">7</div><div style="line-height:130%">8</div><div style="line-height:130%">9</div><div style="line-height:130%">10</div><div style="line-height:130%">11</div><div style="line-height:130%">12</div><div style="line-height:130%">13</div><div style="line-height:130%">14</div></div></td><td style="padding:6px 0;text-align:left"><div style="margin:0;padding:0;color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%"><div style="padding:0 6px; white-space:pre; line-height:130%">Page<span style="color:#0086b3"></span><span style="color:#a71d5d">&lt;</span>Item<span style="color:#0086b3"></span><span style="color:#a71d5d">&gt;</span>&nbsp;findPage&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;itemRepository.findAll(pageable);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#999999">//&nbsp;Pageable&nbsp;ํ์์&nbsp;Dto๋ก&nbsp;๋ฐ๊พธ๋&nbsp;๋ก์ง</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">Page<span style="color:#0086b3"></span><span style="color:#a71d5d">&lt;</span>RecommendItemDto<span style="color:#0086b3"></span><span style="color:#a71d5d">&gt;</span>&nbsp;dtoPage&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;findPage.map(<span style="color:#a71d5d">new</span>&nbsp;Function<span style="color:#0086b3"></span><span style="color:#a71d5d">&lt;</span>Item,&nbsp;RecommendItemDto<span style="color:#0086b3"></span><span style="color:#a71d5d">&gt;</span>()&nbsp;{</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;@Override</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#a71d5d">public</span>&nbsp;RecommendItemDto&nbsp;apply(Item&nbsp;item)&nbsp;{</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RecommendItemDto&nbsp;dto&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;<span style="color:#a71d5d">new</span>&nbsp;RecommendItemDto();</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dto.setItemId(item.getId());</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dto.setPrice(item.getPrice());</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dto.setThumbnail(item.getThumbnail());</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dto.setItemName(item.getItemName());</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#a71d5d">return</span>&nbsp;dto;</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;});</div></div></td></tr></table></div>
  </div></details>
  
<details>
  <summary> 3. CORS ์ด์ </summary>
  <div>
  &nbsp;&nbsp;&nbsp;&nbsp;(1) ๊ตฌ๊ธ๋ง์ ํตํด ์ฌ๋ฌ ๋ฐฉ๋ฒ์ผ๋ก ์ ์ฉํด๋ณด์์ผ๋, ์ง์์ ์ผ๋ก CORS ์ด์ ๋ฐ์<br/>  
  &nbsp;&nbsp;&nbsp;&nbsp;(2) ํ๋ก์ ํธ ์ฌ์์ฑ์ ํตํด ์ด์ ํด๊ฒฐ ๐ <br/>  
  </div>
</details>

<details>
  <summary> 4. ๋ก๊ทธ์ธ์ด ํ์ํ์ง ์์ ํ์ด์ง์์, ๋ก๊ทธ์ธ์ ์์ฒญํ๋ ์ด์ </summary>
  <div>
  &nbsp;&nbsp;&nbsp;&nbsp;(1) JWT ํ ํฐ์ ๊ฒ์ฌํ์ง ์๋๋ก PATH ์ค์ ์ ํ์์ผ๋, ์ ์์ ์ผ๋ก ๋์ํ์ง ์์์<br/>  
  &nbsp;&nbsp;&nbsp;&nbsp;(2) PATH ์์ฑ ์, '๋์ด์ฐ๊ธฐ'๋ฅผ ์ ๊ฑฐํจ์ผ๋ก ์ด์ 1์ฐจ ํด๊ฒฐ ๐ <br/>  
  &nbsp;&nbsp;&nbsp;&nbsp;(3) ์ผ๋ถ ๋ก์ง์์ 'FormLoginFilter'๋ก ๋ก๊ทธ์ธ ์์ฒญ์ ํ๋ ์ํฉ ๋ฐ์<br/>  
  &nbsp;&nbsp;&nbsp;&nbsp;(4) ๊ธฐ์กด Spring Security์ Login ๋ก์ง ๋์ , ์ง์  Login API ๊ตฌํํจ์ผ๋ก ์ด์ ํด๊ฒฐ<br/>
  </div>
</details>
