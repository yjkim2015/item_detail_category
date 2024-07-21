-- 브랜드 테이블에 브랜드 A 추가
INSERT INTO Brand (name) VALUES ('A');
INSERT INTO Brand (name) VALUES ('B');
INSERT INTO Brand (name) VALUES ('C');
INSERT INTO Brand (name) VALUES ('D');
INSERT INTO Brand (name) VALUES ('E');
INSERT INTO Brand (name) VALUES ('F');
INSERT INTO Brand (name) VALUES ('G');
INSERT INTO Brand (name) VALUES ('H');
INSERT INTO Brand (name) VALUES ('I');


-- 카테고리 테이블에 카테고리 정보 추가 (예시)
INSERT INTO Category (name) VALUES ('상의');
INSERT INTO Category (name) VALUES ('아우터');
INSERT INTO Category (name) VALUES ('바지');
INSERT INTO Category (name) VALUES ('스니커즈');
INSERT INTO Category (name) VALUES ('가방');
INSERT INTO Category (name) VALUES ('모자');
INSERT INTO Category (name) VALUES ('양말');
INSERT INTO Category (name) VALUES ('액세사리');

-- 제품 테이블에 제품 정보 추가 (카테고리 id 사용)
INSERT INTO Product (category_id, price, brand_id) VALUES (1, 11200, 1);
INSERT INTO Product (category_id, price, brand_id) VALUES (2, 5500, 1);
INSERT INTO Product (category_id, price, brand_id) VALUES (3, 4200, 1);
INSERT INTO Product (category_id, price, brand_id) VALUES (4, 9000, 1);
INSERT INTO Product (category_id, price, brand_id) VALUES (5, 2000, 1);
INSERT INTO Product (category_id, price, brand_id) VALUES (6, 1700, 1);
INSERT INTO Product (category_id, price, brand_id) VALUES (7, 1800, 1);
INSERT INTO Product (category_id, price, brand_id) VALUES (8, 2300, 1);

INSERT INTO Product (category_id, price, brand_id) VALUES (1, 10500, 2);
INSERT INTO Product (category_id, price, brand_id) VALUES (2, 5900, 2);
INSERT INTO Product (category_id, price, brand_id) VALUES (3, 3800, 2);
INSERT INTO Product (category_id, price, brand_id) VALUES (4, 9100, 2);
INSERT INTO Product (category_id, price, brand_id) VALUES (5, 2100, 2);
INSERT INTO Product (category_id, price, brand_id) VALUES (6, 2000, 2);
INSERT INTO Product (category_id, price, brand_id) VALUES (7, 2000, 2);
INSERT INTO Product (category_id, price, brand_id) VALUES (8, 2200, 2);

INSERT INTO Product (category_id, price, brand_id) VALUES (1, 10000, 3);
INSERT INTO Product (category_id, price, brand_id) VALUES (2, 6200, 3);
INSERT INTO Product (category_id, price, brand_id) VALUES (3, 3300, 3);
INSERT INTO Product (category_id, price, brand_id) VALUES (4, 9200, 3);
INSERT INTO Product (category_id, price, brand_id) VALUES (5, 2200, 3);
INSERT INTO Product (category_id, price, brand_id) VALUES (6, 1900, 3);
INSERT INTO Product (category_id, price, brand_id) VALUES (7, 2200, 3);
INSERT INTO Product (category_id, price, brand_id) VALUES (8, 2100, 3);

INSERT INTO Product (category_id, price, brand_id) VALUES (1, 10100, 4);
INSERT INTO Product (category_id, price, brand_id) VALUES (2, 5100, 4);
INSERT INTO Product (category_id, price, brand_id) VALUES (3, 3000, 4);
INSERT INTO Product (category_id, price, brand_id) VALUES (4, 9500, 4);
INSERT INTO Product (category_id, price, brand_id) VALUES (5, 2500, 4);
INSERT INTO Product (category_id, price, brand_id) VALUES (6, 1500, 4);
INSERT INTO Product (category_id, price, brand_id) VALUES (7, 2400, 4);
INSERT INTO Product (category_id, price, brand_id) VALUES (8, 2000, 4);


INSERT INTO Product (category_id, price, brand_id) VALUES (1, 10700, 5);
INSERT INTO Product (category_id, price, brand_id) VALUES (2, 5000, 5);
INSERT INTO Product (category_id, price, brand_id) VALUES (3, 3800, 5);
INSERT INTO Product (category_id, price, brand_id) VALUES (4, 9900, 5);
INSERT INTO Product (category_id, price, brand_id) VALUES (5, 2300, 5);
INSERT INTO Product (category_id, price, brand_id) VALUES (6, 1800, 5);
INSERT INTO Product (category_id, price, brand_id) VALUES (7, 2100, 5);
INSERT INTO Product (category_id, price, brand_id) VALUES (8, 2100, 5);

INSERT INTO Product (category_id, price, brand_id) VALUES (1, 11200, 6);
INSERT INTO Product (category_id, price, brand_id) VALUES (2, 7200, 6);
INSERT INTO Product (category_id, price, brand_id) VALUES (3, 4000, 6);
INSERT INTO Product (category_id, price, brand_id) VALUES (4, 9300, 6);
INSERT INTO Product (category_id, price, brand_id) VALUES (5, 2100, 6);
INSERT INTO Product (category_id, price, brand_id) VALUES (6, 1600, 6);
INSERT INTO Product (category_id, price, brand_id) VALUES (7, 2300, 6);
INSERT INTO Product (category_id, price, brand_id) VALUES (8, 1900, 6);

INSERT INTO Product (category_id, price, brand_id) VALUES (1, 10500, 7);
INSERT INTO Product (category_id, price, brand_id) VALUES (2, 5800, 7);
INSERT INTO Product (category_id, price, brand_id) VALUES (3, 3900, 7);
INSERT INTO Product (category_id, price, brand_id) VALUES (4, 9000, 7);
INSERT INTO Product (category_id, price, brand_id) VALUES (5, 2200, 7);
INSERT INTO Product (category_id, price, brand_id) VALUES (6, 1700, 7);
INSERT INTO Product (category_id, price, brand_id) VALUES (7, 2100, 7);
INSERT INTO Product (category_id, price, brand_id) VALUES (8, 2000, 7);

INSERT INTO Product (category_id, price, brand_id) VALUES (1, 10800, 8);
INSERT INTO Product (category_id, price, brand_id) VALUES (2, 6300, 8);
INSERT INTO Product (category_id, price, brand_id) VALUES (3, 3100, 8);
INSERT INTO Product (category_id, price, brand_id) VALUES (4, 9700, 8);
INSERT INTO Product (category_id, price, brand_id) VALUES (5, 2100, 8);
INSERT INTO Product (category_id, price, brand_id) VALUES (6, 1600, 8);
INSERT INTO Product (category_id, price, brand_id) VALUES (7, 2000, 8);
INSERT INTO Product (category_id, price, brand_id) VALUES (8, 2000, 8);

INSERT INTO Product (category_id, price, brand_id) VALUES (1, 11400, 9);
INSERT INTO Product (category_id, price, brand_id) VALUES (2, 6700, 9);
INSERT INTO Product (category_id, price, brand_id) VALUES (3, 3200, 9);
INSERT INTO Product (category_id, price, brand_id) VALUES (4, 9500, 9);
INSERT INTO Product (category_id, price, brand_id) VALUES (5, 2400, 9);
INSERT INTO Product (category_id, price, brand_id) VALUES (6, 1700, 9);
INSERT INTO Product (category_id, price, brand_id) VALUES (7, 1700, 9);
INSERT INTO Product (category_id, price, brand_id) VALUES (8, 2400, 9);