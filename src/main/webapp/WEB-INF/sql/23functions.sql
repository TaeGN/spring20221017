-- 내장 함수들
USE w3schools;

-- MIN : 가장 작은 값 
SELECT * FROM Products ORDER BY Price DESC;
SELECT MIN(Price) FROM Products;

-- MAX : 가장 큰 값
SELECT MAX(Price) FROM Products;

SELECT MIN(CustomerName) FROM Customers;
SELECT MAX(CustomerName) FROM Customers;
SELECT * FROM Customers ORDER BY CustomerName DESC;

-- 직원 생일 중 가장 먼저 태어난 사람의 생일
SELECT MIN(BirthDate) FROM Employees;
-- 가장 어린 사람의 생일
SELECT MAX(BirthDate) FROM Employees;

-- COUNT : 몇 개의 데이터가 있는지 리턴
SELECT * FROM Customers;
SELECT COUNT(*) FROM Customers;
SELECT COUNT(CustomerName) FROM Customers;
SELECT COUNT(ContactName) FROM Customers;
-- COUNT 함수 NULL은 생략
INSERT INTO Customers (ContactName, City, Country)
VALUES ('captain', 'ny', 'USA');

-- 100.00 달러가 넘는 상품의 수 Products

-- 60년대 (60~69)에 태어난 직원의 수


