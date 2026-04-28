-- 코드를 작성해주세요
select he.DEPT_ID, hd.DEPT_NAME_EN, ROUND(AVG(he.SAL)) as AVG_SAL from HR_EMPLOYEES he
join HR_DEPARTMENT hd on he.DEPT_ID = hd.DEPT_ID
group by DEPT_ID
order by AVG_SAL DESC
;