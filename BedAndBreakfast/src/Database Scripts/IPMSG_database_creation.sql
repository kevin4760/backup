
DROP TABLE hotels CASCADE CONSTRAINTS;
CREATE TABLE hotels (
  hotel_id VARCHAR2(10),
  hotel_name varchar2(50) NOT NULL, 
  PRIMARY KEY (hotel_id)
  );
  
DROP TABLE rooms CASCADE CONSTRAINTS;
CREATE TABLE rooms (
  rm_no VARCHAR2(5),
  use_count NUMERIC(8,2),
  beds NUMBER(2),
  hotel_id VARCHAR2(10),
  clean NUMBER(1),
  PRIMARY KEY (rm_no),
  CONSTRAINT rooms_fk 
    FOREIGN KEY(hotel_id) REFERENCES hotels(hotel_id)  
  );

DROP TABLE employees CASCADE CONSTRAINTS;
CREATE TABLE employees (
  emp_id  VARCHAR2(10),
  hotel_id VARCHAR2(10),
  last_name VARCHAR2(50),
  first_name VARCHAR2(10),
  user_name VARCHAR2(10),
  password VARCHAR2(20),
  PRIMARY KEY (emp_id),
  CONSTRAINT employees_fk
    FOREIGN KEY (hotel_id) REFERENCES hotels(hotel_id)
  );
  
DROP TABLE guests CASCADE CONSTRAINTS;
CREATE TABLE guests (
  guest_no VARCHAR2(10),
  last_name VARCHAR2(50),
  first_name VARCHAR2(50),
  title VARCHAR2(5),
  PRIMARY KEY (guest_no)
  );
  
DROP TABLE reservations CASCADE CONSTRAINTS;
CREATE TABLE reservations (
  res_no VARCHAR2(10),
  rm_no VARCHAR2(5),
  guest_no VARCHAR2(10),
  in_date DATE,
  out_date DATE,
  price DECIMAL(9,2),
  PRIMARY KEY (res_no),
  CONSTRAINT reservations_fk 
    FOREIGN KEY (rm_no) REFERENCES rooms(rm_no),
    FOREIGN KEY (guest_no) REFERENCES guests(guest_no)
  );
  
DROP TABLE addresses CASCADE CONSTRAINTS;
CREATE TABLE addresses (
  guest_no VARCHAR2(10),
  street VARCHAR2(20),
  city VARCHAR2(10),
  state VARCHAR2(2),
  zip VARCHAR2(2),
  PRIMARY KEY (guest_no, street),
  CONSTRAINT addresses_fk
    FOREIGN KEY (guest_no) REFERENCES guests(guest_no)
)

DROP TABLE business_dates CASCADE CONTRAINTS;
CREATE TABLE business_date(
  emp_id  VARCHAR2(10),
  hotel_id VARCHAR2(10),
  business_date DATE,
  occupied_rooms NUMBER(10),
  total_rooms NUMBER(10),
  PRIMARY KEY (business_date),
  CONSTRAINT bd_employees_fk
    FOREIGN KEY (emp_id) REFERENCES employees(emp_id),
  CONSTRAINT bd_hotel_fk
    FOREIGN KEY (hotel_id) REFERENCES hotels(hotel_id)
  );

--being night audit code written by Prasanna
CREATE OR REPLACE PACKAGE night_audit AS
    FUNCTION roll_date(employee IN employees.emp_id%TYPE, hotel IN hotels.hotel_id%TYPE) 
      RETURN BOOLEAN;
END night_audit;

CREATE OR REPLACE FUNCTION roll_date(employee IN employees.emp_id%TYPE, hotel IN hotels.hotel_id%TYPE) 
  RETURN BOOLEAN AS
    TYPE no_show_res_type IS RECORD(
      res_no reservations.res_no%TYPE,
      use_count rooms.use_count%TYPE,
      rm_no rooms.rm_no%TYPE
    );
    new_business_date business_dates.business_date%TYPE;
    business_date business_dates.business_date%TYPE;
    occupied NUMBER;
    total NUMBER;
    no_show_res no_show_res_type;
    checkedin reservations%ROWTYPE;
    --find the reservations that are due in but have not been checked in
    CURSOR res_cursor IS SELECT a.res_no, b.use_count,b.rm_no FROM reservations a, rooms b
      WHERE a.rm_no = b.rm_no AND a.in_date <= business_date AND a.status=0;
    --find the reservations that are checked in for the room use count incrememnt
    CURSOR checkedin_cursor IS SELECT * FROM reservations WHERE status=1;

    BEGIN
      --find the current business date
      SELECT MAX(business_date) INTO business_date FROM business_dates;
      --find the new business date
      SELECT MAX(business_date) + 1 INTO new_business_date FROM business_dates;
      --find the number of reservations that are checked in
      SELECT COUNT(*) INTO occupied FROM reservations WHERE status = 1;
      --find the total number of rooms in the hotel
      SELECT COUNT(*) INTO total FROM rooms;

      OPEN res_cursor;
      OPEN checkedin_cursor;

      --create a new business date record
      INSERT 
          INTO business_dates(emp_id, hotel_id, business_date, occupied_rooms, total_rooms)
          VALUES (employee, hotel, new_business_date, occupied, total);

      LOOP
          FETCH res_cursor INTO no_show_res;
          EXIT WHEN res_cursor%NOTFOUND;
          --change arrival reservations to no show
          UPDATE reservations res SET status = 4 WHERE res.res_no = no_show_res.res_no;
      END LOOP;
      LOOP
        FETCH checkedin_cursor INTO checkedin;
        EXIT WHEN checkedin_cursor%NOTFOUND;
        --add use_count for checked in reservations 
        UPDATE rooms r SET use_count = r.use_count + 1 
            WHERE r.rm_no = checkedin.rm_no;
        --change all checked in rooms to dirty
        UPDATE rooms r SET clean = 1 WHERE r.rm_no = checkedin.rm_no;
      END LOOP;
    RETURN TRUE;
    EXCEPTION
      WHEN DUP_VAL_ON_INDEX THEN
      RETURN FALSE;
END roll_date;