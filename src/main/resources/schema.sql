create table if not exists user (
    user_id bigint not null auto_increment primary key,
    nickname varchar(30) not null,
    password varchar(50) not null,
    contact_number varchar(13) not null,
    role tinyint(1) not null
);

create table if not exists book (
    book_id bigint not null auto_increment primary key,
    book_name varchar(100) not null,
    author varchar(50) not null,
    genre varchar(20) not null,
    publication_year year not null
);

create table if not exists loan (
    loan_id bigint not null auto_increment primary key,
    user_id bigint not null,
    book_id bigint not null,
    loan_date timestamp not null,
    return_date timestamp not null,
    state tinyint(1)
);