SELECT * 
FROM Customers c JOIN Orders o 
                 JOIN Employees e;

-- 총 rows : cRow * oRow * eRow
-- 총 cols : cCol + oCol + eCol
SELECT Count(*) FROM Customers; -- 91
SELECT Count(*) FROM Employees; -- 9
SELECT Count(*) FROM Orders; -- 830
SELECT Count(*) 
FROM Customers c JOIN Orders o 
                 JOIN Employees e;
                 
DESC Customers; -- 7 cols
DESC Orders; -- 5 cols
DESC Employees; -- 6 cols


SELECT c.CustomerName, e.FirstName, e.LastName
FROM Customers c JOIN Orders o ON c.CustomerID = o.CustomerID
                 JOIN Employees e ON o.EmployeeID = e.EmployeeID
WHERE o.OrderDate = '1996-07-04';


-- '1996-07-04'에 주문을 처리한 직원이름과 배송한 배송자명 조회
SELECT e.FirstName, e.LastName, s.ShipperName
FROM Orders o JOIN Employees e ON o.EmployeeID = e.EmployeeID
              JOIN Shippers s ON o.ShipperID = s.ShipperID
WHERE o.OrderDate = '1996-07-04';

-- '1996-07-04'에 주문 고객, 직원, 배송자
SELECT c.CustomerName, e.FirstName, e.LastName, s.ShipperName
FROM Orders o JOIN Employees e ON o.EmployeeID = e.EmployeeID
              JOIN Shippers s ON o.ShipperID = s.ShipperID
              JOIN Customers c ON o.CustomerID = c.CustomerID
WHERE o.OrderDate = '1996-07-04';






                 
                 
                 ;
                 
                 
                 
                 