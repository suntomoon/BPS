create table EMPLOYEE (
	ID int unsigned not null auto_increment, 
	FIRSTNAME varchar(20), 
	LASTNAME varchar(20), 
	EMAIL varchar(100) not null, 
	TELEPHONE varchar(20), 
	primary key(ID)
) engine=innodb default charset=utf8 auto_increment=1;

create table CUSTOMER (
	ID int unsigned not null auto_increment, 
	FIRSTNAME varchar(20), LASTNAME varchar(20), 
	EMAIL varchar(100) not null, 
	TELEPHONE varchar(20), 
	BILLDATE varchar(20), 
	primary key(ID)
) engine=innodb default charset=utf8 auto_increment=1;

create table ORDERTABLE (
	ID int unsigned not null auto_increment, 
	CUSTOMERID int unsigned,
	CUSTOMERNAME varchar(20),
	ORDERSTARTDATE varchar(20), 
	ORDERENDDATE varchar(20), 
	primary key(ID),
	CONSTRAINT `ORDER_FK_1` FOREIGN KEY (`CUSTOMERID`) REFERENCES `CUSTOMER` (`ID`) on delete cascade on update cascade
) engine=innodb default charset=utf8 auto_increment=1;

create table ORDERPLAN (
	ID int unsigned not null auto_increment, 
	ORDERID int unsigned, 
	ORDERPLANNAME varchar(20), 
	primary key(ID),
	CONSTRAINT `ORDERPLAN_FK_1` FOREIGN KEY (`ORDERID`) REFERENCES `ORDERTABLE` (`ID`) on delete cascade on update cascade
) engine=innodb default charset=utf8 auto_increment=1;

create table ORDERITEM (
	ID int unsigned not null auto_increment, 
	ORDERPLANID int unsigned,
	ORDERITEMNAME varchar(20), 
	CHARGETYPE varchar(20),
	CHARGEMODE varchar(20),
	AMOUNT varchar(20),
	BILLRUNDATE varchar(20),
	primary key(ID),
	CONSTRAINT `ORDERITEM_FK_1` FOREIGN KEY (`ORDERPLANID`) REFERENCES `ORDERPLAN` (`ID`) on delete cascade on update cascade
) engine=innodb default charset=utf8 auto_increment=1;

create table PRODUCT (ID int unsigned not null auto_increment, NAME varchar(20), DESCRIPTION varchar(100), primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;

create table PRODUCTRATEPLAN (ID int unsigned not null auto_increment, PRODUCTID int, PRODUCTNAME varchar(20), PLANNAME varchar(20), PLANDESCRIPTION varchar(100),primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;

create table PRODUCTITEM (ID int unsigned not null auto_increment, PLANID int, ITEMNAME varchar(20), CHARGEMODEL varchar(20),  CHARGETYPE varchar(20), PRODUCTITEMDESCRIPTION varchar(100),primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;

create table INVOICE (
	ID int unsigned not null auto_increment, 
	INVOICEID varchar(20), 
	INVOICEDATE varchar(20), 
	AMOUNT varchar(20),
	primary key(ID)
) engine=innodb default charset=utf8 auto_increment=1;

create table BILLRUN (
	ID int unsigned not null auto_increment, 
	CUSTOMERID varchar(20), 
	BILLRUNENDDATE varchar(20),
	primary key(ID)
) engine=innodb default charset=utf8 auto_increment=1;