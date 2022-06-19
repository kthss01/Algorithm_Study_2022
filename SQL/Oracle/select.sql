-- 595 Big Countries
-- 조건에 맞는 countries 조회
SELECT
    world.name
    , world.population
    , world.area
FROM
    World world
WHERE
    world.area >= 3000000
    OR world.population >= 25000000
;

-- 1757 Recyclable and Low Fat Products
-- low fat and recyclable 한거 조회
SELECT
    pro.product_id
FROM
    Products pro
WHERE
    pro.low_fats = 'Y'
    AND pro.recyclable = 'Y'
;

-- 584 Find Customer Referee
-- customer referee_id not 2 인거 조회
SELECT
    cust.name
FROM
    Customer cust
WHERE
    cust.referee_id IS NULL 
    OR cust.referee_id != 2
;

-- 183 Customers Who Never Order
-- 주문안한 손님 찾기
SELECT
    cust.name Customers
FROM
    Customers cust
    LEFT OUTER JOIN Orders ord ON cust.id = ord.customerId
WHERE
    ord.customerId IS NULL
;