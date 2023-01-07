create table artist (
    id int primary key auto_increment,
    email nvarchar(125) not null,
    password varchar(128) not null,
    nickname nvarchar(100) not null,
    registrationDate datetime not null
);

create table art(
    id int primary key auto_increment,
    artistId int,
    name nvarchar(200) not null,
    imageUrl nvarchar(2048) not null,
    createdAt datetime not null,
    foreign key (artistId) references artist(id)
);

