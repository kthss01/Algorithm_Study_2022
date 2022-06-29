-- 175. Combine Two Tables
-- Person Table과 Address Table 합치기
SELECT
    PER.firstName
    , PER.lastName
    , ADDR.city
    , ADDR.state
FROM
    Person PER
    LEFT OUTER JOIN Address ADDR 
    ON PER.personId = ADDR.personId
;


-- 1581. Customer Who Visited but Dit not Make Any Transactions
-- Visits 테이블과 Transactions 테이블이 있는데 Transactions 테이블 없이 방문한 거 갯수 출력
SELECT
    VIS.customer_id 
    , COUNT(*) AS "count_no_trans"
FROM
    Visits VIS
    LEFT OUTER JOIN Transactions TRANS
    ON VIS.visit_id = TRANS.visit_id
WHERE
    TRANS.transaction_id IS NULL
GROUP BY
    VIS.customer_id
;