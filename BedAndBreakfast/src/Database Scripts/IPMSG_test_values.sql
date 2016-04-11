INSERT INTO hotels (hotel_id, hotel_name) Values('001', 'ManCavia');
INSERT INTO hotels (hotel_id, hotel_name) VALUES('002', 'WorstWestern');

INSERT INTO  employees (EMP_ID , HOTEL_ID, FIRST_NAME , LAST_NAME, USER_NAME, PASSWORD)
  VALUES('E001', '001', 'Kevin', 'Fry', 'KF001', 'enter');

INSERT INTO  employees (EMP_ID , HOTEL_ID, FIRST_NAME , LAST_NAME)
  VALUES('E002', '001', 'Aaron', 'Coffman');

Commit;

SELECT * FROM test_values;

DELETE FROM test_values
WHERE name>'A';

desc table test_values;