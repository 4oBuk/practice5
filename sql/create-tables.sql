create table artist (
    id bigint primary key auto_increment,
    email nvarchar(125) unique not null,
    password varchar(128) not null,
    nickname nvarchar(100) unique not null,
    registration_date datetime not null
);

create table illustration(
    id bigint primary key auto_increment,
    artist_id bigint,
    name nvarchar(200) not null,
    image_url nvarchar(2048) not null,
    created_at datetime not null,
    foreign key (artist_id) references artist(id)
);

