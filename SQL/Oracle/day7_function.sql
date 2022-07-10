-- 1141. User Activity for the Past 30 Days!
-- 2019-07-27부터 30일 이전의 user activity 찾기
SELECT
    TO_CHAR(ACT.activity_date, 'YYYY-MM-DD') AS "day"
    , COUNT(DISTINCT(ACT.user_id)) AS "active_users"
FROM
    Activity ACT
WHERE
    ACT.activity_date BETWEEN '2019-06-28' AND '2019-07-27'
GROUP BY
    ACT.activity_date
ORDER BY 
    ACT.activity_date
;

-- 1693. Daily Leads and Partners
-- 날짜별 제조품별 leader와 partner 갯수 조회
SELECT
    TO_CHAR(DSAL.date_id, 'YYYY-MM-DD') AS "date_id"
    , DSAL.make_name
    , COUNT(DISTINCT(DSAL.lead_id)) AS "unique_leads"
    , COUNT(DISTINCT(DSAL.partner_id)) AS "unique_partners"
FROM
    DailySales DSAL
GROUP BY
    DSAL.date_id, DSAL.make_name
;

-- 1729. Find Followers Count
-- user별 follower 갯수 조회
-- user_id 별로 정렬
SELECT
    FOL.user_id
    , COUNT(*) AS "followers_count"
FROM
    Followers FOL
GROUP BY 
    FOl.user_id
ORDER BY 
    FOL.user_id
;