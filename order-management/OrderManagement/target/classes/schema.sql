create table SL_ORDERS
(
    id integer not null auto_increment,
    name varchar(255) not null,
    total_amount integer not null,
    primary key(id)
);

create table SL_ITEMS
(
    item_id integer not null,
    order_id integer not null,
    name varchar(255) not null,
    quantity integer not null,
    price integer not null,
    primary key(item_id)
);

alter table SL_ITEMS add foreign key (order_id) references SL_ORDERS(id);