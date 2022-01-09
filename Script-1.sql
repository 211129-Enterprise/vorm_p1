ALTER USER postgres WITH PASSWORD 'postgres';

drop table if exists students cascade;
create table students ();