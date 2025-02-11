-- 코드를 작성해주세요
SELECT hd.DEPT_ID, hd.DEPT_NAME_EN, ROUND(AVG(he.SAL), 0) AS AVG_SAL
FROM HR_DEPARTMENT hd
JOIN HR_EMPLOYEES he ON hd.DEPT_ID = he.DEPT_ID
GROUP BY he.DEPT_ID
ORDER BY ROUND(AVG(he.SAL), 1) DESC;