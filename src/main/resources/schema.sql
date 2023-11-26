drop table user;

create table user (
    id bigint not null auto_increment primary key,
    nickname varchar(30) not null,
    password varchar(50) not null,
    contact_number varchar(13) not null,
    role bit(1) not null
);