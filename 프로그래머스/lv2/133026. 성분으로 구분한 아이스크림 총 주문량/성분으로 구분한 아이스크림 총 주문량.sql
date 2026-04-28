-- 코드를 입력하세요
# SELECT * from ICECREAM_INFO
# ;

SELECT ii.INGREDIENT_TYPE, sum(fh.total_order) as TOTAL_ORDER from FIRST_HALF fh
join ICECREAM_INFO ii on ii.flavor = fh.flavor
group by ingredient_type
order by TOTAL_ORDER asc;
;