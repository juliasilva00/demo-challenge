create table mock_db (
    id bigint identity not null,
    rate bigint not null,
    movie varchar(255),
    primary key (id)
);