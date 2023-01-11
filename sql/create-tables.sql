create table artist (
    id bigint primary key auto_increment,
    email nvarchar(125) unique not null,
    password varchar(128) not null,
    nickname nvarchar(100) unique not null,
    registrationDate datetime not null
);

create table illustration(
    id bigint primary key auto_increment,
    artistId bigint,
    name nvarchar(200) not null,
    imageUrl nvarchar(2048) not null,
    createdAt datetime not null,
    foreign key (artistId) references artist(id)
);

