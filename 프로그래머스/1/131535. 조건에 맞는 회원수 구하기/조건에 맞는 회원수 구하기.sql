-- 코드를 입력하세요
SELECT COUNT(USER_ID) AS USERS FROM USER_INFO
WHERE AGE BETWEEN 20 and 29
AND JOINED BETWEEN '2021-01-01' and '2021-12-31';