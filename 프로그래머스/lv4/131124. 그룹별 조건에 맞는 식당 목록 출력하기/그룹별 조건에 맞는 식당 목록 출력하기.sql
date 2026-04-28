-- 코드를 입력하세요
SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, DATE_FORMAT(RR.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
FROM MEMBER_PROFILE MP
JOIN REST_REVIEW RR
    ON MP.MEMBER_ID = RR.MEMBER_ID
WHERE MP.MEMBER_ID IN (
    SELECT M.MEMBER_ID
    FROM (
        SELECT MEMBER_ID, COUNT(*) AS CNT 
        FROM REST_REVIEW GROUP BY MEMBER_ID
    ) M
    WHERE M.CNT = (
        SELECT MAX(X.CNT) 
        FROM (
            SELECT COUNT(*) AS CNT 
            FROM REST_REVIEW GROUP BY MEMBER_ID
        ) X
    )
)
ORDER BY RR.REVIEW_DATE, RR.REVIEW_TEXT;

# MEMBER_PROFILE와 REST_REVIEW 테이블에서 
# 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 SQL문을 작성해주세요.
# 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성해주시고, 
# 결과는 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 
# 리뷰 텍스트를 기준으로 오름차순 정렬해주세요.