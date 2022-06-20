-- 1873 Calculate Special Bonus
-- odd number이고 이름이 M으로 시작하지 않는 employee의 salary 출력
SELECT
    EMP.employee_id
    ,   CASE WHEN MOD(EMP.employee_id, 2) = 1 AND EMP.name NOT LIKE 'M%'
                THEN EMP.salary
            ELSE 0
        END AS bonus 
FROM
    Employees EMP   
    ;

-- 627 Swap Salary
-- f <->  m 으로 뒤집기
-- single update statement로 no intermediate temporary tables
SELECT
    SAL.id
    , SAL.name
    , DECODE(SAL.sex, 'f', 'm', 'm', 'f') AS sex
    , SAL.salary
FROM
    Salary SAL
    ;
