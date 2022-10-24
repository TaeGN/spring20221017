SELECT * 
FROM Orders
WHERE OrderDate = '1996-07-04';

SELECT *
FROM OrderDetails
WHERE OrderID = 10248;

SELECT * 
FROM Products
WHERE ProductID IN (11, 42, 72);

-- '1996-07-04'에 주문된 상품명들 조회
SELECT p.ProductName
FROM Orders o JOIN OrderDetails d ON o.OrderID = d.OrderID
              JOIN Products p ON d.ProductID = p.ProductID
WHERE o.OrderDate = '1996-07-04';

-- '1996-07-04'에 주문한 총 주문 금액
SELECT SUM(d.Quantity * p.Price)
FROM Orders o JOIN OrderDetails d ON o.OrderID = d.OrderID
              JOIN Products p ON d.ProductID = p.ProductID
WHERE o.OrderDate = '1996-07-04';

-- 각 날짜별 매출액(판매금액)
SELECT o.OrderDate, SUM(d.Quantity * p.Price)
FROM Orders o JOIN OrderDetails d ON o.OrderID = d.OrderID
              JOIN Products p ON d.ProductID = p.ProductID
GROUP BY o.OrderDate
ORDER BY o.OrderDate ;


-- 고객별 주문 총 금액 조회
SELECT c.CustomerID, 
       c.CustomerName, 
       SUM(d.Quantity * p.Price) Total
FROM Customers c JOIN Orders o ON c.CustomerID = o.CustomerID
			     JOIN OrderDetails d ON o.OrderID = d.OrderID
                 JOIN Products p ON d.ProductID = p.ProductID
GROUP BY c.CustomerID 
HAVING Total >= 10000
ORDER BY c.CustomerID;
                 









