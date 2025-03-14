
create table patients(
id int(10) not null auto_increment,
name varchar(50) not null,
age varchar(3) not null,
gender varchar(7) not null,
primary key(id)
);

create table doctors(
id int(10) not null auto_increment,
name varchar(50) not null,
specialization varchar(50) not null,
primary key(id)
);

create table appointments(
id int(10) not null auto_increment,
patient_id int (10) not null,
doctor_id int(10) not null,
appointment_date date not null,
primary key(id),
foreign key (patient_id) references patients(id),
foreign key (doctor_id) references doctors(id)
);



