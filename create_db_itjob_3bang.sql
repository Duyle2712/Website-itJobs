use db_itjobs;

create table tbl_recruiter(
	email varchar(50) primary key not null,
    password varchar(250)
);

create table tbl_congviec(
	macv bigint primary key not null auto_increment,
    chucdanh varchar(100),
    capbac varchar(50),
    loaicv int,
    diadiem varchar(250),
    mota varchar(2000),
    yeucau varchar(2000),
    mucluong bigint,
    ngonngu varchar(50),
    nguoilienhe varchar(50),
    status int,
    email varchar(50) not null,
    CONSTRAINT fk_recruiter FOREIGN KEY (email) REFERENCES tbl_recruiter (email)
);

