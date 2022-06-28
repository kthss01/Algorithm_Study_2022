-- 1965 Employees With Missing Information
-- name 이나 salary 없는 애들 모두 조회하기 id순으로 정렬

-- mysql 이거 oracle로 돌리면 runtime 에러남
-- SELECT 
--     * 
-- FROM (
--     SELECT
--         EMP.employee_id
--     FROM
--         Employees EMP LEFT OUTER JOIN Salaries SAL USING(employee_id)
--     WHERE
--         SAL.salary IS NULL

--     UNION 

--     SELECT
--         SAL.employee_id
--     FROM
--         Salaries SAL LEFT OUTER JOIN Employees EMP USING(employee_id)
--     WHERE
--         EMP.name IS NULL
-- ) EMP
-- ORDER BY EMP.employee_id
-- ;

SELECT 
    EMPLOY.employee_id
FROM (
    SELECT
        EMP.employee_id
    FROM
        Employees EMP LEFT OUTER JOIN Salaries SAL
            ON EMP.employee_id = SAL.employee_id    
    WHERE
        SAL.salary IS NULL

    UNION 

    SELECT
        SAL.employee_id
    FROM
        Salaries SAL LEFT OUTER JOIN Employees EMP 
            ON EMP.employee_id = SAL.employee_id
    WHERE
        EMP.name IS NULL
) EMPLOY
ORDER BY EMPLOY.employee_id
;

-- 1795 Rearrange Products Table
-- rearrange - 재정렬
-- 각 컬럼들 row로 구분해서 union 하기
SELECT
    PRO.product_id
    , PRO.store
    , PRO.price
FROM (
    SELECT
        PRO1.product_id
        , 'store1' AS store
        , PRO1.store1 AS price
    FROM
        Products PRO1
    WHERE
        PRO1.store1 IS NOT NULL

    UNION

    SELECT
        PRO2.product_id
        , 'store2' AS store
        , PRO2.store2 AS price
    FROM
        Products PRO2
    WHERE
        PRO2.store2 IS NOT NULL

    UNION

    SELECT
        PRO3.product_id
        , 'store3' AS store
        , PRO3.store3 AS price
    FROM
        Products PRO3
    WHERE
        PRO3.store3 IS NOT NULL
) PRO
;

-- 608 Tree Node
-- Leaf, Root, Inner 로 type이 나뉘어 있음
-- parent 보고 root inner leaf 로 표시
-- 정렬은 id 오름차순
SELECT
    TR.id
    -- , LEVEL
    , CASE
        WHEN LEVEL = 1 THEN 'Root'
        WHEN CONNECT_BY_ISLEAF = 1 THEN 'Leaf' -- 자식노드가 있으면 0 없으면 1
        ELSE 'Inner'
    END AS type
FROM
    Tree TR
START WITH TR.p_id IS NULL -- 최상위 노드 설정
CONNECT BY PRIOR TR.id = TR.p_id -- 부모노드와 자식노드 연결
-- ORDER BY TR.id -- 정렬 필요x 계층 구조별로 자동 정렬되기 때문
ORDER SIBLINGS BY TR.id -- 계층형 구조 보존하면서 정렬하려면
-- 레벨이 같은 형제 로우에 한해서 정렬되는거
;

-- 176 Second Highest Salary
-- 2번째로 연봉이 높은 데이터 조회하기 없으면 null
-- rownum 먼저해봤는데 그거 안됨

-- rownum 작동방식 (https://jhnyang.tistory.com/454)
-- rownum은 테이블 where 절이 실행될 때 조건에 맞음녀 1을 부여
-- 맞지 않으면 번호를 부여하지 않고 버리는 방식
-- rownum = 1 일 경우 where 조건 후 첫 번째 행에서 rownum = 1을 만족하니 하나의 데이터를 가져옴
-- 하지만 rownum = 2 일 경우 where 조건 결과의 첫 번재 행의 순번이 2가 아닌 1이니까
-- 이 결과를 버리게 되고, 2가 버려졌으니 그 다음에 만족하는 행 또한 1이 될텐데
-- 조건 2에 부합하지 않으니까 또 버려짐
-- 이런 작동방식으로 인해 rownum = 1이 아니면 어떤 결과도 추출될 수 없ㅇ므

-- 추가 order by rownum 같이 썼을 경우
-- where절이 실행되었을 때 줄세우기를 하기 때문에
-- 그냥 테이블 조회시 처음부터 10개 데이터에 순번 매기고
-- 그 결과값을 정렬한 것에 지나지 않음
-- 정렬을 먼저하고 10개 추출하는게 아니라
-- 10개를 먼저 추출하고 정렬해서 값이 안맞음

-- 이 방법도 null인 경우 처리 못함
-- SELECT
--     E.salary AS "SecondHighestSalary", 
-- FROM (
--     SELECT 
--         EMP.salary 
--         , RANK() OVER (ORDER BY EMP.salary DESC) AS RK
--     FROM 
--         Employee EMP
-- ) E
-- WHERE
--     E.RK = 2
-- ;

SELECT
    MAX(EMP.salary) as "SecondHighestSalary"
FROM Employee EMP
WHERE 
    EMP.salary <= (
        CASE WHEN EMP.salary < (
                                    SELECT 
                                        MAX(EMP2.salary)
                                    FROM
                                        Employee EMP2
                                ) THEN EMP.salary
            ELSE
                null
        END
    )
;
