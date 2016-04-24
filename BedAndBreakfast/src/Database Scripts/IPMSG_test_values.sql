/*creates test values in database

/*create hotels*/
INSERT INTO hotels (hotel_id, hotel_name) Values('001', 'ManCavia');
INSERT INTO hotels (hotel_id, hotel_name) VALUES('002', 'WorstWestern');


/*create employees and system users*/
INSERT ALL
  INTO  employees (EMP_ID , HOTEL_ID, FIRST_NAME , LAST_NAME, USER_NAME, PASSWORD)
    VALUES('E001', '001', 'Kevin', 'Fry', 'kf001', 'enter')
  INTO  employees (EMP_ID , HOTEL_ID, FIRST_NAME , LAST_NAME, USER_NAME, PASSWORD)
    VALUES('E002', '001', 'Aaron', 'Coffman', 'AC001', 'ilovecats')
  INTO  employees (EMP_ID , HOTEL_ID, FIRST_NAME , LAST_NAME, USER_NAME, PASSWORD)
    VALUES('E003', '001', 'Gregory', 'hicks', 'GH001', 'boomgoesthe')
  INTO  employees (EMP_ID , HOTEL_ID, FIRST_NAME , LAST_NAME, USER_NAME, PASSWORD)
    VALUES('E004', '001', 'Prasanna', 'Singh', 'PS001', 'ipman')
  INTO  employees (EMP_ID , HOTEL_ID, FIRST_NAME , LAST_NAME, USER_NAME, PASSWORD)
    VALUES('E005', '001', 'Lyandro', 'Japon', 'LJ001', 'squidbite')
SELECT * FROM dual;

/*add hotel rooms*/
INSERT ALL
  INTO rooms (rm_no, hotel_id, use_count, beds, clean) VALUES ('101', '001', 0, 2, 1)
  INTO rooms (rm_no, hotel_id, use_count, beds, clean) VALUES ('102', '001', 0, 2, 1)
  INTO rooms (rm_no, hotel_id, use_count, beds, clean) VALUES ('103', '001', 0, 2, 1)
  INTO rooms (rm_no, hotel_id, use_count, beds, clean) VALUES ('104', '001', 0, 2, 1)
  INTO rooms (rm_no, hotel_id, use_count, beds, clean) VALUES ('105', '001', 0, 2, 1)
  INTO rooms (rm_no, hotel_id, use_count, beds, clean) VALUES ('106', '001', 0, 1, 1)
  INTO rooms (rm_no, hotel_id, use_count, beds, clean) VALUES ('107', '001', 0, 1, 1)
  INTO rooms (rm_no, hotel_id, use_count, beds, clean) VALUES ('108', '001', 0, 1, 1)
  INTO rooms (rm_no, hotel_id, use_count, beds, clean) VALUES ('109', '001', 0, 1, 1)
  INTO rooms (rm_no, hotel_id, use_count, beds, clean) VALUES ('110', '001', 0, 1, 1)
SELECT * FROM dual;

/*adds 100 guests, no titles used*/
INSERT ALL 
INTO guests(guest_no, last_name, first_name) VALUES ('	359276	','	Holman	','	Hamish	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1898337	','	Haney	','	Maia	')
INTO guests(guest_no, last_name, first_name) VALUES ('	3097520	','	Bailey	','	Kennan	')
INTO guests(guest_no, last_name, first_name) VALUES ('	9080345	','	Myers	','	Xander	')
INTO guests(guest_no, last_name, first_name) VALUES ('	6842530	','	Jacobs	','	Candace	')
INTO guests(guest_no, last_name, first_name) VALUES ('	8347152	','	Cochran	','	Nerea	')
INTO guests(guest_no, last_name, first_name) VALUES ('	6552653	','	Hampton	','	Zeus	')
INTO guests(guest_no, last_name, first_name) VALUES ('	3326895	','	Farley	','	Cleo	')
INTO guests(guest_no, last_name, first_name) VALUES ('	2709189	','	Holmes	','	Dawn	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1828355	','	Middleton	','	Oren	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1837130	','	Riley	','	William	')
INTO guests(guest_no, last_name, first_name) VALUES ('	9907959	','	Gutierrez	','	Stephanie	')
INTO guests(guest_no, last_name, first_name) VALUES ('	3288901	','	Guerra	','	Isabella	')
INTO guests(guest_no, last_name, first_name) VALUES ('	2550542	','	Gates	','	Carlos	')
INTO guests(guest_no, last_name, first_name) VALUES ('	6061838	','	Puckett	','	Minerva	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1435630	','	Ford	','	Nelle	')
INTO guests(guest_no, last_name, first_name) VALUES ('	3562458	','	Haley	','	Adam	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7477764	','	Holden	','	Fiona	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1910379	','	Rodgers	','	Cailin	')
INTO guests(guest_no, last_name, first_name) VALUES ('	4420063	','	Bird	','	Nevada	')
INTO guests(guest_no, last_name, first_name) VALUES ('	5551673	','	Eaton	','	Ross	')
INTO guests(guest_no, last_name, first_name) VALUES ('	5663632	','	Cummings	','	Meghan	')
INTO guests(guest_no, last_name, first_name) VALUES ('	2342661	','	Dixon	','	Carly	')
INTO guests(guest_no, last_name, first_name) VALUES ('	318730	','	Marks	','	Xenos	')
INTO guests(guest_no, last_name, first_name) VALUES ('	2262127	','	Guerra	','	Martina	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1457317	','	Carney	','	May	')
INTO guests(guest_no, last_name, first_name) VALUES ('	8479880	','	Gill	','	Peter	')
INTO guests(guest_no, last_name, first_name) VALUES ('	2310590	','	Ratliff	','	Alea	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1532355	','	Spencer	','	Lael	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7895579	','	Craft	','	Hanna	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1390946	','	Pratt	','	Jaime	')
INTO guests(guest_no, last_name, first_name) VALUES ('	8079909	','	Cox	','	Neville	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7586181	','	Wade	','	Theodore	')
INTO guests(guest_no, last_name, first_name) VALUES ('	5234106	','	Perkins	','	MacKenzie	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7090636	','	Hart	','	Kasper	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1592201	','	Irwin	','	Tallulah	')
INTO guests(guest_no, last_name, first_name) VALUES ('	2689073	','	Garner	','	Michelle	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1297506	','	Carson	','	Oprah	')
INTO guests(guest_no, last_name, first_name) VALUES ('	531084	','	Tillman	','	Wilma	')
INTO guests(guest_no, last_name, first_name) VALUES ('	9387534	','	Banks	','	Lareina	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7031671	','	Kelly	','	Claire	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1345979	','	Wooten	','	Paula	')
INTO guests(guest_no, last_name, first_name) VALUES ('	9720893	','	Haney	','	Ryder	')
INTO guests(guest_no, last_name, first_name) VALUES ('	9721886	','	Evans	','	Talon	')
INTO guests(guest_no, last_name, first_name) VALUES ('	3942498	','	Mckinney	','	Herrod	')
INTO guests(guest_no, last_name, first_name) VALUES ('	433285	','	Hoover	','	Candice	')
INTO guests(guest_no, last_name, first_name) VALUES ('	5698243	','	Bowers	','	Dominic	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1043913	','	Pennington	','	Jayme	')
INTO guests(guest_no, last_name, first_name) VALUES ('	6098814	','	Walter	','	Moana	')
INTO guests(guest_no, last_name, first_name) VALUES ('	8481713	','	Cook	','	Quamar	')
INTO guests(guest_no, last_name, first_name) VALUES ('	3962333	','	Mckay	','	Nell	')
INTO guests(guest_no, last_name, first_name) VALUES ('	6246971	','	Hewitt	','	Drake	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7732479	','	Petty	','	Emerson	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1864392	','	Cherry	','	Kendall	')
INTO guests(guest_no, last_name, first_name) VALUES ('	8169180	','	Burgess	','	Nicholas	')
INTO guests(guest_no, last_name, first_name) VALUES ('	2898626	','	Wilkerson	','	Audrey	')
INTO guests(guest_no, last_name, first_name) VALUES ('	8784905	','	Bowman	','	Dawn	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7947229	','	Mullins	','	Ezekiel	')
INTO guests(guest_no, last_name, first_name) VALUES ('	4214373	','	Wood	','	Lee	')
INTO guests(guest_no, last_name, first_name) VALUES ('	5827252	','	Graves	','	Meghan	')
INTO guests(guest_no, last_name, first_name) VALUES ('	9267473	','	Newman	','	Nayda	')
INTO guests(guest_no, last_name, first_name) VALUES ('	8756717	','	Sharp	','	Imogene	')
INTO guests(guest_no, last_name, first_name) VALUES ('	9541351	','	Wolf	','	Kaitlin	')
INTO guests(guest_no, last_name, first_name) VALUES ('	6359317	','	Galloway	','	Candice	')
INTO guests(guest_no, last_name, first_name) VALUES ('	4172998	','	Herring	','	Orla	')
INTO guests(guest_no, last_name, first_name) VALUES ('	5689572	','	Pittman	','	Mason	')
INTO guests(guest_no, last_name, first_name) VALUES ('	2173783	','	Daniels	','	Adena	')
INTO guests(guest_no, last_name, first_name) VALUES ('	6480031	','	Mcdaniel	','	Maile	')
INTO guests(guest_no, last_name, first_name) VALUES ('	3753311	','	Lane	','	Veda	')
INTO guests(guest_no, last_name, first_name) VALUES ('	8574526	','	Thornton	','	Lucy	')
INTO guests(guest_no, last_name, first_name) VALUES ('	2893820	','	Horne	','	Mona	')
INTO guests(guest_no, last_name, first_name) VALUES ('	4882031	','	Hutchinson	','	Genevieve	')
INTO guests(guest_no, last_name, first_name) VALUES ('	245476	','	Dalton	','	Brynn	')
INTO guests(guest_no, last_name, first_name) VALUES ('	4747069	','	Schwartz	','	Seth	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1445932	','	King	','	Brielle	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7741095	','	Preston	','	Zorita	')
INTO guests(guest_no, last_name, first_name) VALUES ('	4051479	','	Shelton	','	Jonas	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7910473	','	Carney	','	Marah	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7977355	','	Riddle	','	Xanthus	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1544249	','	Vincent	','	Karen	')
INTO guests(guest_no, last_name, first_name) VALUES ('	6294576	','	Duffy	','	Jamalia	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1387576	','	Reyes	','	Damian	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1659756	','	Richmond	','	Burton	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1689245	','	Alvarez	','	Sasha	')
INTO guests(guest_no, last_name, first_name) VALUES ('	353990	','	Torres	','	Mollie	')
INTO guests(guest_no, last_name, first_name) VALUES ('	363400	','	Moses	','	Octavia	')
INTO guests(guest_no, last_name, first_name) VALUES ('	4986543	','	Rios	','	Nita	')
INTO guests(guest_no, last_name, first_name) VALUES ('	6596088	','	Hubbard	','	Sacha	')
INTO guests(guest_no, last_name, first_name) VALUES ('	2702388	','	Wheeler	','	Zia	')
INTO guests(guest_no, last_name, first_name) VALUES ('	9747504	','	Oliver	','	Candace	')
INTO guests(guest_no, last_name, first_name) VALUES ('	4495773	','	Leach	','	Eaton	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1577582	','	Sampson	','	Chiquita	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7843506	','	Rosales	','	James	')
INTO guests(guest_no, last_name, first_name) VALUES ('	171066	','	Alston	','	Alma	')
INTO guests(guest_no, last_name, first_name) VALUES ('	1981301	','	Wiggins	','	Christopher	')
INTO guests(guest_no, last_name, first_name) VALUES ('	3518703	','	Mcguire	','	Risa	')
INTO guests(guest_no, last_name, first_name) VALUES ('	6153352	','	Hull	','	Germane	')
INTO guests(guest_no, last_name, first_name) VALUES ('	9286851	','	Harmon	','	Caleb	')
INTO guests(guest_no, last_name, first_name) VALUES ('	7666641	','	Bray	','	Alana	')
INTO guests(guest_no, last_name, first_name) VALUES ('	9846003	','	Cooke	','	Kylee	')
SELECT * FROM dual;

/*commits all work above this line*/
COMMIT;
/*WARNING: anything below COMMIT will not save to the database*/
 
 
/*
desc table reservations;
select * from guests;
/*desc table guests;
select * from guests;
delete from guests where last_name <= 'a';*/
INSERT ALL
  INTO business_dates(emp_id, hotel_id, business_date, occupied_rooms, total_rooms) VALUES ('E1100', '001', SYSDATE, 0, 0)
SELECT * FROM dual;