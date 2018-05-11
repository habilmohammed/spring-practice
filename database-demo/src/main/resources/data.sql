/* No need to create when using JPA and in memory db. Table would be created by schema update(spring auto config).
create table person(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);

*/

insert into person
(id,name,location,birth_date)
values(10001, 'Habil', 'Bangalore', sysdate());

insert into person
(id,name,location,birth_date)
values(10002, 'James', 'New York', sysdate());

insert into person
(id,name,location,birth_date)
values(10003, 'Peter', 'Amsterdam', sysdate());