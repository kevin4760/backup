
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

CREATE OR REPLACE PACKAGE night_audit AS
    FUNCTION roll_date(employee IN employees.emp_id%TYPE, hotel IN hotels.hotel_id%TYPE) 
      RETURN BOOLEAN AS
      new_business_date AS business_dates.business_date%TYPE;
      business_date AS business_dates.business_date%TYPE;
      occupied_rooms AS NUMBER;
      total_rooms AS NUMBER;

      SELECT MAX(business_date) INTO business_date FROM business_dates;
      SELECT MAX(business_date) + 1 INTO new_business_date FROM business_dates;
      SELECT COUNT(*) INTO occupied FROM reservations WHERE status = 1;
      SELECT COUNT(*) INTO total FROM rooms;      
      CURSOR res_cursor IS SELECT a.res_no, b.use_count,b.rm_no FROM reservations a, rooms b
        WHERE a.rm_no = b.rm_no AND a.in_date <= business_date AND a.status=0;
      CURSOR checkedin_cursor IS SELECT res_no FROM reservations WHERE status=1;

      BEGIN
        --create a new business date record
        INSERT 
            INTO busines_dates(emp_id, hotel_id, business_date, occupied_rooms, total_rooms)
            VALUES (employee, hotel, new_business_date, occupied, total);
        
        LOOP
            FETCH res_cursor INTO no_show_res
            EXIT WHEN res_cursor%NOTFOUND;
            --change arrival reservations to no show
            UPDATE reservations res SET status = 4 WHERE res.res_no = res_cursor.res_no;
            --add use_count for checked in reservations 
            UPDATE rooms r SET use_count = r.use_count + 1 
                WHERE r.rm_no = checkedin_cursor.rm_no;
        END LOOP;
      EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
        RETURN FALSE;
      RETURN TRUE;
    END roll_date;
END night_audit;