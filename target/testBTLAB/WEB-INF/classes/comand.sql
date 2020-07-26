CREATE TABLE product(
  id SERIAL PRIMARY KEY,
  name varchar (512) not null ,
  description varchar (1024),
  create_date date ,
  place_storage integer,
  reserved boolean
);

set client_encoding='UTF-8';