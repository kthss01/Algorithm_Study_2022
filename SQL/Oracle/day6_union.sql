-- 197. Rising Temperature
-- 이전 날짜보다 온도 높은 날짜 조회
SELECT
    WET1.id
FROM 
    WEATHER WET1, WEATHER WET2
WHERE
    WET1.temperature > WET2.temperature
    AND WET1.recordDate - 1 = WET2.recordDate
;

-- 607. Sales Person
-- RED 회사에 어떠한 주문도 받지 않은 salespersons 이름 조회하기
SELECT
    SPER.name
FROM
    SalesPerson SPER
WHERE
    SPER.sales_id NOT IN (
        SELECT 
            ORD.sales_id
        FROM 
            Orders ORD
            INNER JOIN Company COM USING(com_id)
        WHERE
            COM.name = 'RED'
    )
;