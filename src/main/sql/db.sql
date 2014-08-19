create table EMPLOYEE (ID int unsigned not null auto_increment, FIRSTNAME varchar(20), LASTNAME varchar(20), EMAIL varchar(100) not null, TELEPHONE varchar(20), primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;

create table CUSTOMER (ID int unsigned not null auto_increment, FIRSTNAME varchar(20), LASTNAME varchar(20), EMAIL varchar(100) not null, TELEPHONE varchar(20), BILLDATE varchar(20), primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;

create table ORDERTABLE (ID int unsigned not null auto_increment, CUSTOMERID varchar(20), ORDERSTARTDATE varchar(20), ORDERENDDATE varchar(20), primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;

create table PRODUCT (ID int unsigned not null auto_increment, NAME varchar(20), DESCRIPTION varchar(100), primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;

create table PRODUCTRATEPLAN (ID int unsigned not null auto_increment, PRODUCTID int, PRODUCTNAME varchar(20), PLANNAME varchar(20), PLANDESCRIPTION varchar(100),primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;

create table PRODUCTITEM (ID int unsigned not null auto_increment, PLANID int, ITEMNAME varchar(20), CHARGEMODEL varchar(20),  CHARGETYPE varchar(20), PRODUCTITEMDESCRIPTION varchar(100),primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;

create table INVOICE (ID int unsigned not null auto_increment, INVOICEID varchar(20), INVOICEDATE varchar(20), AMOUNT varchar(20) ,primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;