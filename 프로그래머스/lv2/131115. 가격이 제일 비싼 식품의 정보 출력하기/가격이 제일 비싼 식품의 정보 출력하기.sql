-- 코드를 입력하세요
SELECT * FROM FOOD_PRODUCT where price = (Select max(price) from FOOD_PRODUCT);