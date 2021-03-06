drop table autouser if exists;
drop table vehicle if exists;

create table autouser (
	userid bigint generated by default as identity,
	name varchar(255),
	primary key (userid)
);

create table vehicle (
	vehicleid bigint generated by default as identity,
	make varchar(255),
	model varchar(255),
	userid bigint,
	primary key(vehicleid)
);

alter table vehicle 
    add constraint FK_vehicle_autouser
    foreign key (userid) 
    references autouser;

insert into autouser(userid, name) values(null, 'Alice Bob');
insert into autouser values (null, 'Bob Bob');
insert into autouser values (null, 'Caty Bob');

insert into vehicle values(1, 'Toyota', 'Camry', 1);
insert into vehicle values(2, 'Honda', 'Lexus', 1);
insert into vehicle values(3, 'Ford', 'Focus', 2);