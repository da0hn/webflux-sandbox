CREATE TABLE users
(
    id      serial
        constraint pk_id_user primary key,
    name    varchar(50),
    balance double precision
);

CREATE TABLE transactions
(
    id      serial
        constraint pk_id_transaction primary key,
    user_id bigint,
    amount  double precision,
    date    timestamp,
    foreign key (user_id) references users (id) on delete cascade
);

