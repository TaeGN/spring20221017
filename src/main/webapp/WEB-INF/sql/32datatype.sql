USE mydb1;

-- data type
-- 문자열
-- VARCHAR, CHAR

-- 수
-- INT, DEC

-- 날짜
-- DATE, DATETIME


-- 문자열
-- VARCHAR(size) : size까지의 문자열 저장 가능
CREATE TABLE myTable01 (
	col1 VARCHAR(5),
    col2 VARCHAR(2)
);
INSERT INTO myTable01 (col1, col2)
VALUES ('abcde', 'ab'); -- ok
INSERT INTO myTable01 (col1, col2)
VALUES ('abc', 'a'); -- ok
INSERT INTO myTable01 (col1, col2)
VALUES ('abc', 'abc'); -- not ok
SELECT * FROM myTable01;























