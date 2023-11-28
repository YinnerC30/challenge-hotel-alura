create database "db-hotel-alura";
create table if not exists reservations
(
    id_reservation   int auto_increment
    primary key,
    date_of_entry    date                 null,
    date_of_exit     date                 null,
    value_stay_price float                null,
    form_payment     varchar(50)          null,
    total            float                null,
    is_active        tinyint(1) default 1 null
    );

create table if not exists clients
(
    id_client      int auto_increment
    primary key,
    name           varchar(50)          null,
    last_name      varchar(50)          null,
    date_of_birth  date                 null,
    nacionality    varchar(50)          null,
    telephone      varchar(10)          null,
    id_reservation int                  null,
    is_active      tinyint(1) default 1 null,
    constraint clients_reservations_id_reservation_fk
    foreign key (id_reservation) references reservations (id_reservation)
    );

create table if not exists users
(
    id_user   int auto_increment
    primary key,
    name      varchar(50)          null,
    last_name varchar(50)          null,
    password  varchar(50)          null,
    is_active tinyint(1) default 1 null
    );

INSERT INTO users (name, last_name, password, is_active) VALUES ('admin', 'admin', '1234admin', 1);


