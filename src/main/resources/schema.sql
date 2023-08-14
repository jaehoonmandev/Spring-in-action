create table if not exists Parts(
    id varchar(30) primary key,
    name varchar(50) not null,
    type varchar(10) not null
    );

create table if not exists Setup(
    id identity,
    name varchar(50) not null,
    createdAt timestamp not null
    );

create table if not exists "Order"(
    id identity,
    createdAt timestamp not null,
    deliveryName varchar(50) not null,
    deliveryCity varchar(50) not null,
    deliveryState varchar(50) not null,
    deliveryStreet varchar(2) not null,
    deliveryZip varchar(10) not null,
    ccNum varchar(16) not null,
    ccExpiration varchar(5) not null,
    ccCVV varchar(3) not null
    );

create table if not exists Order_Setup(
    "Order" bigint not null,
    Setup bigint not null
);

alter table Order_Setup add foreign key ("Order") references "Order"(id);
alter table Order_Setup add foreign key (Setup) references Setup(id);

create table if not exists Setup_Parts(
      Setup bigint not null,
      Parts bigint not null
);

alter table Setup_Parts add foreign key (Setup) references Setup(id);
alter table Setup_Parts add foreign key (Parts) references Parts(id);