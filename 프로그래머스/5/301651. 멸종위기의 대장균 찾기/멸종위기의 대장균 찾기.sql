-- 코드를 작성해주세요
WITH RECURSIVE GenerationCTE AS (
    -- 기본 케이스: 1세대 (부모가 없는 최초의 대장균들)
    SELECT ID, 1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    -- 재귀 케이스: 다음 세대들
    SELECT e.ID, g.GENERATION + 1
    FROM ECOLI_DATA e
    INNER JOIN GenerationCTE g ON e.PARENT_ID = g.ID
),
NoChildCTE AS (
    -- 자식이 없는 대장균 찾기
    SELECT g.ID, g.GENERATION
    FROM GenerationCTE g
    LEFT JOIN ECOLI_DATA e ON g.ID = e.PARENT_ID
    WHERE e.ID IS NULL
)
-- 최종 결과: 세대별 자식 없는 대장균 수 집계
SELECT COUNT(*) AS COUNT, GENERATION
FROM NoChildCTE
GROUP BY GENERATION
ORDER BY GENERATION;