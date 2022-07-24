-- 1393. Capital Gain/Loss
-- stock 별로 그룹해서 총합을 구하기
SELECT
    Sell.stock_name
    , (Sell.sellPrice - Buy.buyPrice) AS "capital_gain_loss"
FROM
    (
        SELECT sell.stock_name, SUM(sell.price) sellPrice
        FROM Stocks sell
        WHERE sell.operation  = 'Sell'
        GROUP BY sell.stock_name
    ) Sell 
    JOIN
    (
        SELECT buy.stock_name, SUM(buy.price) buyPrice
        FROM Stocks buy
        WHERE buy.operation  = 'Buy'
        GROUP BY buy.stock_name
    ) Buy
    ON Sell.stock_name = Buy.stock_name
;

-- 1407. Top Travellers
-- 각 Rides 별 거리합을 거리별, 이름 순으로 정렬
SELECT
    Users.name
    , NVL(Rides.distance, 0) AS "travelled_distance" 
FROM
    Users
    LEFT OUTER JOIN
    (
        SELECT
            user_id
            , SUM(distance) AS distance
        FROM
            Rides 
        Group By 
            user_id    
    ) Rides
    ON Users.id = Rides.user_id
ORDER BY
    NVL(Rides.distance, 0) DESC
    , Users.name ASC
;

-- 1158. Market Analysis 1
-- 각각의 사용자, join date 별로 2019년에 buyer 였던 수 조회하기
SELECT
    Users.user_id AS buyer_id
    , TO_CHAR(Users.join_date, 'YYYY-MM-DD') AS join_date
    , NVL(Orders.count, 0) AS orders_in_2019
FROM
    Users
    LEFT OUTER JOIN
    (
        SELECT
            buyer_id
            , COUNT(*) AS count
        FROM
            Orders
        WHERE
            EXTRACT(YEAR FROM TO_DATE(order_date, 'YYYY-MM-DD')) = '2019'
        GROUP BY
            buyer_id
    ) Orders
    ON Users.user_id = Orders.buyer_id
ORDER BY
    Users.user_id
;