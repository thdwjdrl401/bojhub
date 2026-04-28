-- 코드를 입력하세요
SELECT NAME, COUNT(*) as COUNT from ANIMAL_INS where NAME is not null GROUP BY NAME HAVING COUNT(*) >= 2 order by NAME;