# [MUSINSA] Java(Kotlin) Backend Engineer - 과제



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



# 준비사항

h2 database 설치



Application.yml 파일에

h2 관련하여 사용하시는 정보 입력



# 빌드

terminal -> 해당 프로젝트 폴더 이동(itemcategory)

./gradlew assemble



결과물

build -> libs -> itemcategory-0.0.1-SNAPSHOT.jar



# 실행

terminal -> 해당 프로젝트 폴더 이동(itemcategory)

java -jar ./build/libs/itemcategory-0.0.1-SNAPSHOT.jar



또는 인텔리제이에 해당 프로젝트 import후 서버 실행

http://localhost:8080/swagger-ui/index.html



# 테스트

terminal -> 해당 프로젝트 폴더 이동 (itemcategory)



./gradlew test



결과물

build -> test-results -> test -> Test-****.xml



또는

서버 구동 후 스웨거를 통한 테스트 가능

http://localhost:8080/swagger-ui/index.html



또는

해당 프로젝트

인텔리제이 import 후 test class 실행



# 엔티티 구조

상품 (N) <- > (1) 브랜드

하나의 브랜드는 여러개의 상품을 가질 수 있다.

상품 (N) <-> (1) 카테고리

하나의 카테고리는 여러개의 상품을 가질 수 있다.



# 구현 범위

#### 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API

○ API 실패 시, 실패값과 실패 사유를 전달해야 합니다.

```
http://localhost:8080/api/v1/category/min-prices
```

```
{
  "상품목록": [
    {
      "카테고리": "가방",
      "브랜드": "A",
      "가격": "2,000"
    },
    {
      "카테고리": "모자",
      "브랜드": "D",
      "가격": "1,500"
    },
    {
      "카테고리": "바지",
      "브랜드": "D",
      "가격": "3,000"
    },
    {
      "카테고리": "상의",
      "브랜드": "C",
      "가격": "10,000"
    },
    {
      "카테고리": "스니커즈",
      "브랜드": "A",
      "가격": "9,000"
    },
    {
      "카테고리": "아우터",
      "브랜드": "E",
      "가격": "5,000"
    },
    {
      "카테고리": "액세사리",
      "브랜드": "F",
      "가격": "1,900"
    },
    {
      "카테고리": "양말",
      "브랜드": "I",
      "가격": "1,700"
    }
  ],
  "총액": "34,100"
}
```



#### 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API

● API 실패 시, 실패값과 실패 사유를 전달해야 합니다.

```
http://localhost:8080/api/v1/category/brand/min-prices
```

```
{
  "최저가": {
    "브랜드": "D",
    "카테고리": [
      {
        "카테고리": "가방",
        "가격": "2,500"
      },
      {
        "카테고리": "모자",
        "가격": "1,500"
      },
      {
        "카테고리": "바지",
        "가격": "3,000"
      },
      {
        "카테고리": "상의",
        "가격": "10,100"
      },
      {
        "카테고리": "스니커즈",
        "가격": "9,500"
      },
      {
        "카테고리": "아우터",
        "가격": "5,100"
      },
      {
        "카테고리": "액세사리",
        "가격": "2,000"
      },
      {
        "카테고리": "양말",
        "가격": "2,400"
      }
    ],
    "총액": "36,100"
  }
}
```



#### 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API

● API 실패 시, 실패값과 실패 사유를 전달해야 합니다.

```
http://localhost:8080/api/v1/category/min-max-prices?categoryName='스니커즈'
```

```
{
  "카테고리": "스니커즈",
  "최저가": [
    {
      "브랜드": "A",
      "가격": "9,000"
    },
    {
      "브랜드": "G",
      "가격": "9,000"
    }
  ],
  "최고가": [
    {
      "브랜드": "E",
      "가격": "9,900"
    }
  ]
}
```



#### 브랜드 및 상품을 추가 / 업데이트 / 삭제하는 API

● 성공 혹은 실패 여부 JSON

● API 실패 시, 실패값과 실패 사유를 전달해야 합니다



product-controller

brand-controller





#### RestControllerAdvice를 통한 Exception 규격 통일





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
SELECT MIN(P2.PRICE)
FROM PRODUCT P2
WHERE P2.CATEGORY_ID = P.CATEGORY_ID
)
ORDER BY C.NAME;
```



```
3번 문제
카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API


최저가와 최고가 내부 데이터가 배열인 것을 미처 확인하지 못한 채 굉장히 쉽게 SQL을 만들었으나
추후에 최저가/최고가 내부 데이터가 배열인 것을 알고 중복이 있을 수 있다는 것을 눈치챘다.
그 이후에 굉장히 복잡한 쿼리를 생성했으며..
native Query를 이용하여 해결.
```

