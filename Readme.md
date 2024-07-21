# 개발환경



| 분야                   | stack                    |
| ---------------------- | ------------------------ |
| 언어                   | Java 17                  |
| 프레임워크             | springBoot 3.1.0, JUnit5 |
| DB                     | h2 Database              |
| 빌드 툴                | Gradle                   |
| Persistence 프레임워크 | JPA/Hibernate            |
| API 테스트 툴          | Postman                  |
| IDE                    | IntelliJ                 |



# API 명세

### 응답 공통



------

##### HTTP 응답코드



| 응답코드 | 설명                  |
| -------- | --------------------- |
| `200`    | **정상 응답**         |
| `400`    | 잘못된 요청           |
| `404`    | 리소스를 찾을 수 없음 |
| `500`    | 시스템 에러           |

##### 에러코드 및 메시지

| 에러 코드 | 에러 메시지 |
| --------- | ----------- |
|           |             |
|           |             |
|           |             |

##### 내용

| 이름   | 타입       | 필수 | 설명                       |
| ------ | ---------- | ---- | -------------------------- |
| data   | object     | ○    | API 별 응답 내용           |
| status | HttpStatus | ○    | API 별 응답 Http 상태 코드 |



#  TROUBLE SHOOTING

```
1번 문제
카테고리 별 최저가격 브랜드와 상품가격을 조회하는 쿼리인데
아래와 같이 쿼리 했을시 문제점이 있었다..
바로 스니커즈가 A브랜드와 G 브랜드가 동일하게 9천원이라는 점
떄문에 스니커즈가 A, G 2개가 나와버린다는 것이다.
이 중복을 해결하기 위해서 서브쿼리 안에 또 서브쿼리를 넣게 되었다..

SELECT C.NAME AS CATEGORY_NAME, B.NAME AS BRAND_NAME, P.PRICE
FROM PRODUCT P
JOIN CATEGORY C ON P.CATEGORY_ID = C.ID
JOIN BRAND B ON P.BRAND_ID = B.ID
WHERE P.PRICE = (
SELECT MIN(P2.PRICE)ㅁ
FROM PRODUCT P2
WHERE P2.CATEGORY_ID = P.CATEGORY_ID
)
ORDER BY C.NAME;
```