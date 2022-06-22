-- 1667 Fix Names in a Table
-- 이름 첫글자 대문자로 변경하고 user_id로 정렬
SELECT
    US.user_id
    , INITCAP(US.name) AS name
FROM Users US
ORDER BY US.user_id
;

-- 1484 Group Sold Products By The Date
-- 각 날짜별로 그룹지어서 몇개씩 팔린지 적기
-- 정렬은 sell_date로 
-- LISTAGG 사용 (https://dololak.tistory.com/809)
-- 참고1 (https://gent.tistory.com/328)
-- 참고2 (https://gent.tistory.com/15)
--- XMLAGG(오라클 9i 이하), WM_CONCAT(오라클 10g~11gR1), LISTAGG(오라클 11gR2 이후)
SELECT
    TO_CHAR(ACT.sell_date, 'YYYY-MM-DD') AS sell_date
    , COUNT(*) AS num_sold
    , LISTAGG(ACT.product, ',') WITHIN GROUP(ORDER BY ACT.product) AS products
FROM
    --Activities ACT
    (
        SELECT
            sell_date, product
        FROM
            Activities
        GROUP BY 
            sell_date, product
        
    ) ACT
GROUP BY 
    ACT.sell_date
;

-- 1527 Patients With a Condition
-- Type이 D1AB1으로 시작하는거 찾기 포함되는거 찾기