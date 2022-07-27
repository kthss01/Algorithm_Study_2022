-- 182. Duplicate Emails
-- 중복되는 이메일 출력하기
SELECT
    email
FROM
    Person
GROUP BY
    email
HAVING 
    COUNT(*) > 1
;

-- 1050. Actors and Directors Who Coop...
-- actor 랑 director 3번이상 함께한 것 조회하기
SELECT
    actor_id
    , director_id
FROM
    ActorDirector
GROUP BY
    actor_id, director_id
HAVING 
    COUNT(*) >= 3
;

-- 1587. Bank Account Summary 2
-- 각 계좌의 금액 합이 10000 이상인거 출력하기
SELECT
    Users.name
    , Trans.balance
FROM
    Users
    LEFT JOIN
    (
        SELECT
            Trans.account
            , SUM(Trans.amount) AS balance
        FROM
            Transactions Trans
        GROUP BY
            Trans.account
    ) Trans
    ON Users.account = Trans.account
WHERE
    Trans.balance >= 10000

-- 1084. Sales Analysis 3
-- 2019-01-01 ~ 2019-03-31 1 쿼터에 오직 팔린 product 구하기
SELECT
    Pro.product_id
    , Pro.product_name
FROM
    Product Pro
WHERE
    Pro.product_id IN (
        SELECT
            Sal.product_id
        FROM
            Sales Sal
        GROUP BY
            Sal.product_id
        HAVING 
            MIN(Sal.sale_date) >= '2019-01-01' AND
            MAX(Sal.sale_date) <= '2019-03-31'
        
    )
;