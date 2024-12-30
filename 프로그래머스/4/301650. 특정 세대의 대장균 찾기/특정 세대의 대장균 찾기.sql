-- 코드를 작성해주세요
SELECT e1.ID FROM ECOLI_DATA e1
JOIN ECOLI_DATA e2 ON e1.PARENT_ID = e2.ID
JOIN ECOLI_DATA e3 ON e2.PARENT_ID = e3.ID
WHERE e3.PARENT_ID IS NULL
ORDER BY ID ASC;
-- parent id 가 null 인 parent id 를 가지고 있는 parent id 를 가지고 있는 id 를 찾으면 된다.
-- parent_id 가 null 인 id 를 가지고 있는 id 를 parent_id 로 가지면 된다는 뜻
