create database dayone default charset 'UTF8';
grant all on dayone.* to james;
use dayone;
create table services
(
  id         int auto_increment unique not null,
  name       varchar(200) not null,
  price      double not null,
  subscribe  boolean not null  
);
insert into services(name,price,subscribe) values('DayOne Standard', 149.0, true);
insert into services(name,price,subscribe) values('DayOne Enterprise', 249.0, true);

insert into services(name,price,subscribe) values('DayOne Setup', 149.0, false);
insert into services(name,price,subscribe) values('SSL Installation', 149.0, false);
insert into services(name,price,subscribe) values('Email Setup on G Suite', 149.0, false);
insert into services(name,price,subscribe) values('User Acceptance Test', 800.0, false);
insert into services(name,price,subscribe) values('Custom Theme Design', 1250.0, false);

create table data_centers
(
  id         int auto_increment unique not null,
  name       varchar(200) not null,
  type       varchar(200) not null -- 'Google', 'DayOne'
);

insert into data_centers(type,name) values('Google', 'Montréal');
insert into data_centers(type,name) values('Google', 'São Paulo');
insert into data_centers(type,name) values('Google', 'Iowa');
insert into data_centers(type,name) values('Google', 'South Carolina');
insert into data_centers(type,name) values('Google', 'Northern Virginia');
insert into data_centers(type,name) values('Google', 'Oregon');
insert into data_centers(type,name) values('Google', 'Los Angeles');
insert into data_centers(type,name) values('Google', 'Salt Lake City');
insert into data_centers(type,name) values('Google', 'Finland');
insert into data_centers(type,name) values('Google', 'Belgium');
insert into data_centers(type,name) values('Google', 'London');
insert into data_centers(type,name) values('Google', 'Frankfurt');
insert into data_centers(type,name) values('Google', 'Netherlands');
insert into data_centers(type,name) values('Google', 'Zürich');
insert into data_centers(type,name) values('Google', 'Taiwan');
insert into data_centers(type,name) values('Google', 'Hong Kong');
insert into data_centers(type,name) values('Google', 'Tokyo');
insert into data_centers(type,name) values('Google', 'Osaka');
insert into data_centers(type,name) values('Google', 'Seoul');
insert into data_centers(type,name) values('Google', 'Mumbai');
insert into data_centers(type,name) values('Google', 'Singapore');
insert into data_centers(type,name) values('Google', 'Sydney');

