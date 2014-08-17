create table EMPLOYEE (ID int unsigned not null auto_increment, FIRSTNAME varchar(20), LASTNAME varchar(20), EMAIL varchar(100) not null, TELEPHONE varchar(20), primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;

create table CUSTOMER (ID int unsigned not null auto_increment, FIRSTNAME varchar(20), LASTNAME varchar(20), EMAIL varchar(100) not null, TELEPHONE varchar(20), BILLDATE varchar(20), primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;

create table ORDERTABLE (ID int unsigned not null auto_increment, CUSTOMERID varchar(20), ORDERDATE varchar(20), primary key(ID)) engine=innodb default charset=utf8 auto_increment=1;