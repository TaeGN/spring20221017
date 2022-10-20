-- 여러행 한번에 수정

UPDATE Customers
SET PostalCode = '00000'
WHERE Country = 'Mexico';

SELECT * FROM Customers
WHERE Country = 'Mexico';

-- DESC : 테이블 구조
DESC Customers;

-- SAFE UPDATE MODE -> disable
SET SQL_SAFE_UPDATES = 0;

-- USA 국가의 고객들의 City 를 New York으로 변경
UPDATE Customers
SET City = 'New York'
WHERE Country = 'USA';
SELECT * FROM Customers
WHERE Country = 'USA';
-- UK 국가의 고객들의 Address를 GangNam으로 변경
UPDATE Customers
SET Address = 'GangNam'
WHERE Country = 'UK';
SELECT * FROM Customers
WHERE Country = 'UK';

UPDATE Customers
SET City = 'Seoul'; 

-- WHERE 절 생략하지 않기
-- UPDATE 실행 전에 같은 WHERE 절로 SELECT 해보기


SELECT * FROM Customers;

