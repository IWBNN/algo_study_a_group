-- 코드를 입력하세요
SELECT 
    YEAR(s.SALES_DATE) AS YEAR,
    MONTH(s.SALES_DATE) AS MONTH,
    COUNT(DISTINCT s.USER_ID) AS PURCHASED_USERS,
    ROUND(COUNT(DISTINCT s.USER_ID) / 
        (SELECT COUNT(*) FROM USER_INFO WHERE YEAR(JOINED) = 2021), 1) AS PUCHASED_RATIO
FROM USER_INFO i
JOIN ONLINE_SALE s ON i.USER_ID = s.USER_ID
WHERE YEAR(i.JOINED) = 2021
GROUP BY YEAR(s.SALES_DATE), MONTH(s.SALES_DATE)
ORDER BY YEAR ASC, MONTH ASC;