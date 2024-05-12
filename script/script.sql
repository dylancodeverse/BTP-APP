create database templateeval ;
\c templateeval ;

create table department(
    id serial primary key,
    dept varchar(250)
);

insert into department values (default,'rh'),(default,'menage');

create table utilisateur(
    id serial primary key,
    utilisateur varchar(250),
    sex integer,
    description varchar(250),
    department integer,
    foreign key(department)references department(id)
);

create table interets(
    id serial primary key,
    interets varchar(250)
);

insert into interets values (default,'jeu'),(default,'basket'),(default,'musique');

create table utilisateurinterets(
    id serial primary key,
    utilisateur integer,
    interets integer,
    foreign key(interets)references interets(id),
    foreign key(utilisateur) references utilisateur(id)

);
