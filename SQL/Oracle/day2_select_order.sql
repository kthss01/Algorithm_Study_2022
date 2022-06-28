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
ORDER BY EMP.employee_id
    ;

-- 627 Swap Salary
-- f <->  m 으로 뒤집기
-- single update statement로 no intermediate temporary tables
-- 조회가 아니라 업데이트 처리하라고 했던거였음
-- SELECT
--     SAL.id
--     , SAL.name
--     , DECODE(SAL.sex, 'f', 'm', 'm', 'f') AS sex
--     , SAL.salary
-- FROM
--     Salary SAL
--     ;

UPDATE Salary SET sex =
    CASE WHEN (SEX LIKE 'f') THEN 'm' ELSE 'f'
    END;

-- 196 Delete Duplicate Emails
-- 중복되는 이메일 제거 오직 가장 짧은 email만 남기기
-- SELECT를 안쓰고 DELETE 쓰라고 함
DELETE FROM Person p
WHERE
    p.id NOT IN (
        SELECT MIN(id) FROM Person GROUP BY email
    )
    ;