Spool 'C:\Users\Kevin\Desktop\workspace\CMIS 495\database\database.txt' replace

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
  rooms INTEGER,
  hotel_id VARCHAR2(10),
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
  hotel_id VARCHAR2(10),
  PRIMARY KEY (guest_no),
  CONSTRAINT guests_fk
    FOREIGN KEY(hotel_id) REFERENCES hotels(hotel_id)
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