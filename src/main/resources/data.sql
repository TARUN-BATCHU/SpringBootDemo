INSERT INTO ORGANIZATION(ORGANIZATION_ID,ORGANIZATION_NAME)
VALUES (1,'EYGDS'),
(2,'EYINDIA'),
(3,'google'),
(4,'microsoft'),
(5,'amazon'),
(6,'hp'),
(7,'dell'),
(8,'intel'),
(9,'twitter'),
(10,'tesla');


INSERT INTO COURSE(COURSE_ID,COURSE_NAME)
VALUES (1,'JAVA'),
(2,'PYTHON'),
(3,'C');

INSERT INTO USERS(USER_ID,DATE_OF_BIRTH,USER_NAME,ORGANIZATION_ID)
VALUES (1,'1993-01-05','hari',1),
(2,'2000-01-15','elon',4),
(3,'1994-12-25','mark',6);
--(4,'1993-01-05','abc',8),
--(5,'2000-01-15','tarun',1),
--(6,'1999-09-25','ram',2),
--(7,'1993-01-05','nag',1),
--(8,'2000-01-15','chiru',1),
--(9,'1997-01-25','dfg',8),
--(10,'1993-01-05','gopal',9),
--(11,'2000-01-15','prabas',7),
--(12,'1999-11-25','ntr',5),
--(13,'1993-01-05','sundar',5),
--(14,'2006-01-15','uttej',7),
--(15,'1999-10-25','dheeraj',3),
--(16,'1993-01-05','bnm',2),
--(17,'2001-01-05','abhi',4),
--(18,'1999-12-25','teja',2),
--(19,'1993-01-05','vignash',10),
--(20,'2000-01-15','sri',9),
--(21,'1999-12-28','kumar',8),
--(22,'1995-05-05','krishna',6),
--(23,'2007-01-15','siva',1),
--(24,'1999-12-25','nagendra',2),
--(25,'1995-01-05','dot',3),
--(26,'2000-01-15','balu',10),
--(27,'1999-12-25','ethin',7);

INSERT INTO HALLTICKET(HALL_TICKET_NUMBER,ROOM_NUMBER,USER_ID)
VALUES (1,101,1),(2,101,2),(3,101,3);
--,(4,101,4),(5,102,5),(6,103,6),(7,103,7),(8,103,8),(9,103,9),(10,102,10);

INSERT INTO COURSE_USERS(USER_ID,COURSE_ID)
VALUES (1,1),(2,1),(3,2);
--,(4,3),(5,2),(6,3),(7,3),(8,3),(9,1),(10,2),(11,2),(12,1),(13,1),(14,3),(15,2),(16,2);


