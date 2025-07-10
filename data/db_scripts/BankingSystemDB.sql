create database bankingsystemdb;
use bankingsystemdb;

show tables;
select * from clients;

create table bank(
	name_bank varchar(256),
    creation_date datetime,
    code_bank int
);

create table credit_card(
	id_credit_card int not null auto_increment primary key,
    code int,
    card_code varchar(256),
    bank varchar(256),
    card_type varchar(256)
);

create table accounts(
	id_account int not null auto_increment primary key,
    id_credit_card int,
    name_account varchar(256),
    code_account varchar(256),
    bank varchar(256),
    balance decimal(10,2),
    creation_date datetime,
    status_account boolean,
    
    foreign key(id_credit_card) references credit_card(id_credit_card)
);

create table clients(
	id_client int not null auto_increment primary key,
    id_account int,
    id_card varchar(256),
	name_client varchar(256),
    adress varchar(256),
    phone_number varchar(256),
    age int,
    
    foreign key(id_account) references accounts(id_account)
);