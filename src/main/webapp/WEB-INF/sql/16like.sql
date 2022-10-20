-- LIKE : 패턴으로 레코드 조회
-- 패턴에서 사용하는 특수기호(wildcard)
--  : % (0개 이상의 문자), _(하나의 문자)

SELECT * FROM Customers WHERE CustomerName LIKE 'A%';
SELECT * FROM Customers WHERE CustomerName LIKE '%A';
SELECT * FROM Customers WHERE CustomerName LIKE '%OR%';
SELECT * FROM Customers WHERE CustomerName LIKE '_R%';
SELECT * FROM Customers WHERE CustomerName LIKE 'A_%_%';
SELECT * FROM Customers WHERE ContactName LIKE 'A%O';

-- firstName이 A로 시작하는 직원들 (Employees)
SELECT * FROM Employees WHERE FirstName LIKE 'A%';
-- ContactName이 E로 끝나는 공급자들 (Suppliers)
SELECT * FROM Suppliers WHERE ContactName LIKE '%E';
-- C로 시작하고 S로 끝나는 상품명들 (Products)
SELECT * FROM Products WHERE ProductName LIKE 'C%S';
-- C로 시작하는 5글자 상품명을 가진 상품들
SELECT * FROM Products WHERE ProductName LIKE 'C____';