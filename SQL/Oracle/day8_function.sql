-- 586. Customer Placing the Largest Number of Orders
-- customer 중에 가장 주문 많이한 사람 찾기
SELECT
    *
FROM (
    SELECT
        customer_number
    FROM Orders 
    GROUP BY customer_number
    ORDER BY COUNT(*) DESC NULLS LAST
)
WHERE
    ROWNUM = 1
;

-- 511. Game Play Analysis 1
-- 각 플레이어의 첫 로그인 날짜 구하기
SELECT
    player_id
    , TO_CHAR(MIN(event_date), 'YYYY-MM-DD') AS "first_login"
FROM
    Activity
GROUP BY player_id
;

-- 1890. The Latest Login in 2020
-- 2020년도의 모든 유저의 마지막 로그인 확인하기
-- 2020년도의 로그인하지 않은 유저는 제외
SELECT
    user_id
    , MAX(time_stamp) AS "last_stamp"
FROM
    Logins
WHERE
    EXTRACT(YEAR FROM time_stamp) = 2020
GROUP BY user_id
;

-- 1741. Find Total Time Spent by Each Employee
-- 근무자마다 날짜별 근무시간 (출퇴근 시간으로 계산) 출력하기
SELECT
    TO_CHAR(event_day, 'YYYY-MM-DD') AS "day"
    , emp_id
    , SUM(out_time - in_time) AS "total_time"
FROM
    Employees
GROUP BY
    event_day, emp_id
;