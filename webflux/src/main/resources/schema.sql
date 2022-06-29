-- !!! this sql file is not run automatically !!!
drop table if exists comment;
create table comment(id bigint primary key  auto_increment, author_name varchar(255), content varchar(500), post_id bigint, foreign key(post_id) references post(id));

drop table if exists post;
create table post(id bigint primary key  auto_increment, title varchar(255), content varchar(2000), visited int);

