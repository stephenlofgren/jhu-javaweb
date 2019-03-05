drop database if exists searchnserve;

create database searchnserve;
use searchnserve;

drop table if exists user;

create table user(
  id int(11) unsigned not null auto_increment,
  name varchar(20),
  email varchar(320),
  primary key (id)
  ) engine=InnoDB auto_increment=1 default charset=UTF8MB4;
  
drop table if exists opportunities;
  
create table opportunities(
  id int(11) unsigned not null auto_increment,
  title varchar(40),
  detail varchar(4000),
  creator int(11),
  date_created datetime,
  status int(4),
  primary key (id)
  ) engine=InnoDB auto_increment=1 default charset=UTF8MB4;

drop table if exists opportunity_status_lu;
  
create table opportunity_status_lu(
  id int(4) unsigned not null auto_increment,
  name varchar(40),
  primary key (id)
  ) engine=InnoDB auto_increment=1 default charset=UTF8MB4;
  
insert into opportunity_status_lu(id, name) values(1, "Pending");
insert into opportunity_status_lu(id, name) values(2, "Open");
insert into opportunity_status_lu(id, name) values(3, "Closed");
  
drop table if exists volunteers;
  
create table volunteers(
  id int(11) unsigned not null auto_increment,
  user_id int(11),
  opportunity_id int(11),
  primary key (id)
  ) engine=InnoDB auto_increment=1 default charset=UTF8MB4;
  
drop table if exists user_favorites;

create table user_favorites(
  id int(11) unsigned not null auto_increment,
  user_id int(11), 
  opportunity_id int(11),
  primary key (id)
  ) engine=InnoDB auto_increment=1 default charset=UTF8MB4;
  
