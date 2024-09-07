CREATE TABLE if not exists category
(
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

create table if not exists product
(
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    available_quantity DOUBLE PRECISION NOT NULL,
    price NUMERIC(38, 2),
    category_id INTEGER
        constraint product_category_id_fk references category
);

create sequence if not exists category_seq increment by 50;
create sequence if not exists product_seq increment by 50;