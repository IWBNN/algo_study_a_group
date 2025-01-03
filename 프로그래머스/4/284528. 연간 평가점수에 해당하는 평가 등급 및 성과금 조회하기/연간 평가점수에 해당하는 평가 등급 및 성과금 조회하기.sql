-- 코드를 작성해주세요
WITH AVG_GRADE AS (
    SELECT 
        EMP_NO,
        AVG(SCORE) as AVG_SCORE,
        CASE
            WHEN AVG(SCORE) >= 96 THEN 'S'
            WHEN AVG(SCORE) >= 90 THEN 'A'
            WHEN AVG(SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE
    FROM HR_GRADE
    GROUP BY EMP_NO
)
SELECT 
    he.EMP_NO,
    he.EMP_NAME,
    ag.GRADE,
    he.SAL * 
    CASE 
        WHEN ag.GRADE = 'S' THEN 0.2
        WHEN ag.GRADE = 'A' THEN 0.15
        WHEN ag.GRADE = 'B' THEN 0.1
        ELSE 0
    END AS BONUS
FROM HR_EMPLOYEES he
JOIN AVG_GRADE ag ON he.EMP_NO = ag.EMP_NO
ORDER BY he.EMP_NO;