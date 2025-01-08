-- 코드를 입력하세요
SELECT j.FLAVOR
FROM FIRST_HALF fh
RIGHT JOIN JULY j ON fh.SHIPMENT_ID = j.SHIPMENT_ID
GROUP BY j.FLAVOR
ORDER BY SUM(fh.TOTAL_ORDER) + SUM(j.TOTAL_ORDER) DESC
LIMIT 3;