CREATE TABLE IF NOT EXISTS `TravelEnthusiast`.`user` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(50) NULL DEFAULT NULL,
  `lastname` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `username` VARCHAR(20) NULL DEFAULT NULL,
  `password` VARCHAR(20) NULL DEFAULT NULL,
  `country` VARCHAR(5) NULL DEFAULT NULL,
  userType int default 0,
  PRIMARY KEY (`ID`));
  
  insert into user 
(firstname, lastname, email, username, password, country) values 
('John', 'Hopkins','Jhopkins@gmail.com','jhopkins','a246135b','USA'); 

insert into user
(firstname, lastname, email, username, password, country, userType) values
('david', 'H', 'dh@gmail.com', 'dhernan','a135246b', 'DR', '1' ); 
  
  create table if not exists TravelEnthusiast.Experience(
  ID int not null auto_increment,
  title varchar(100),
  experience_date date,
  experience_type  varchar(30),
  posted_date timestamp default now(),
  description varchar(250),
  user_id int,
  primary key (ID)
  ); 
  
  insert into Experience
(title, experience_Date, experience_Type, posted_Date, description, user_id) values
('Relaxation in Mexico', '2017-01-20','relaxation', default, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. I
n dapibus ultricies elit. Quisque auctor enim et ipsum consequat, et lobortis ante viverra. 
Phasellus hendrerit rutrum nulla et viverra.', '1');

  insert into Experience
(title, experience_Date, experience_Type, posted_Date, description, user_id) values
('The Wonders of Machu Picchu', '2017-01-20','relaxation', default, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. I
n dapibus ultricies elit. Quisque auctor enim et ipsum consequat, et lobortis ante viverra. 
Phasellus hendrerit rutrum nulla et viverrawefewfefewfefef.', '2');
  
  
  create table if not exists TravelEnthusiast.Event(
  ID int auto_increment,
  event_title varchar(50),
  event_type varchar(50),
  airline varchar (50),
  airline_rating varchar(50),
  hotel varchar (50),
  hotel_rating varchar(50),
  description blob,
  other_recommendations varchar(500),
  experience_id int,
  primary key (ID)
  );
  
  alter table event
  add column(
  posted_date timestamp default now());
  
  alter table event
  add column
  (event_date varchar(50));
  
  insert into event
(event_title, event_type, airline, airline_rating, hotel, hotel_rating, description, other_recommendations, experience_id, event_date) 
values ('Relaxing Day In Mexico', 'beach', 'Future Airlines', '4', 'Majesty Hotel', '5', 'Lorem ipsum dolor sit amet, fabulas percipit suscipiantur pro te. Democritum vituperatoribus ut sea, elitr quaerendum ei vel, vis menandri salutatus te. Ut usu esse illud, mea ei dolore oblique repudiandae. Sint antiopam repudiandae no vix, ei liber nullam alterum cum. Dicam adipisci vulputate vis ut, nostrud periculis salutatus eos no.

Sint suavitate sea an. Pro an nullam quaeque incorrupte, quod audire consequuntur in mel, has te populo minimum interesset. Vocibus voluptatum ne mea. Ut his quodsi scripta intellegebat, sed at insolens consequat. Vidit vulputate ne eum, pri at autem vocent, habemus reprimique ad has.

Pro ne unum nulla dolores, ea senserit expetenda pro. Vitae expetenda mei no. Quis delicata vituperata per id. Usu ne brute assentior. Ius eu brute dolorum, vis malorum necessitatibus ne, ius ut delectus oporteat.

Vix adipisci adolescens eu, no dolor maiorum theophrastus vix, quem odio tollit cu sed. Alii fugit legere in his, sed nibh paulo aeterno no. Sea ex sensibus indoctum, ei pro praesent maiestatis. Nam alia nonumy constituto id, ut usu nullam comprehensam, doctus eleifend antiopam ex eos. Nam an apeirian eleifend electram, at duo virtute deleniti.

Pertinax explicari quo ne, explicari dignissim accommodare mel et, cu per illum labores urbanitas. Usu liber vituperatoribus ei, illum vivendo elaboraret vim te, justo melius discere in ius. Ad soleat integre feugiat nec, duo ornatus omnesque id, eam et denique mandamus hendrerit. Ut has antiopam laboramus torquatos. Ei putant volutpat sea, an veri nostro ius.', 'Ziplining - Escape Tours', '1', '2017-01-21');
  
  
  insert into event
(event_title, event_type, airline, airline_rating, hotel, hotel_rating, description, other_recommendations, experience_id, event_date) 
values ('Hiking to Machu Picchu', 'landmark', 'Past Airline', '5', 'Amazing Hotel', '3', 'Lorem ipsum dolor sit amet, fabulas percipit suscipiantur pro te. Democritum vituperatoribus ut sea, elitr quaerendum ei vel, vis menandri salutatus te. Ut usu esse illud, mea ei dolore oblique repudiandae. Sint antiopam repudiandae no vix, ei liber nullam alterum cum. Dicam adipisci vulputate vis ut, nostrud periculis salutatus eos no. <br>

Sint suavitate sea an. Pro an nullam quaeque incorrupte, quod audire consequuntur in mel, has te populo minimum interesset. Vocibus voluptatum ne mea. Ut his quodsi scripta intellegebat, sed at insolens consequat. Vidit vulputate ne eum, pri at autem vocent, habemus reprimique ad has.

Pro ne unum nulla dolores, ea senserit expetenda pro. Vitae expetenda mei no. Quis delicata vituperata per id. Usu ne brute assentior. Ius eu brute dolorum, vis malorum necessitatibus ne, ius ut delectus oporteat. <br>

Vix adipisci adolescens eu, no dolor maiorum theophrastus vix, quem odio tollit cu sed. Alii fugit legere in his, sed nibh paulo aeterno no. Sea ex sensibus indoctum, ei pro praesent maiestatis. Nam alia nonumy constituto id, ut usu nullam comprehensam, doctus eleifend antiopam ex eos. Nam an apeirian eleifend electram, at duo virtute deleniti. <br>

Pertinax explicari quo ne, explicari dignissim accommodare mel et, cu per illum labores urbanitas. Usu liber vituperatoribus ei, illum vivendo elaboraret vim te, justo melius discere in ius. Ad soleat integre feugiat nec, duo ornatus omnesque id, eam et denique mandamus hendrerit. Ut has antiopam laboramus torquatos. Ei putant volutpat sea, an veri nostro ius.', 'Ziplining - Escape Tours', '3', '2017-01-22');

create table if not exists TravelEnthusiast.Picture(
  ID int not null auto_increment,
  title varchar(25),
  image varchar(150),
  picture_of varchar(50),
  photo_date date,
  landmark boolean,
  description varchar(250),
  experience_id int,
  event_id int,
  primary key (ID)	
  );
  
  insert into picture (title, image, picture_of, photo_date, landmark, description, experience_id) 
  values ('Costa Maya, Mexico', 'file:///Users/david/eclipse-workspace/TravelEnthusiastFinal2/src/static/images/CostaMayaMexico.jpg', 'beach', '2018-08-25', false, 'clear blue water', '1');

insert into picture (title, image, picture_of, photo_date, landmark, description, experience_id) 
values  ('Wonders of Machu Picchu', 'file:///Users/david/eclipse-workspace/TravelEnthusiastFinal2/src/static/images/MachuPicchu.jpg', 'building(s)', '2018-05-15', true,'The amazing Machu Picchu', '3');

insert into picture (title, image, picture_of, photo_date, landmark, description, event_id) 
values  ('Pleasent Beach', 'file:///Users/david/eclipse-workspace/TravelEnthusiastFinal2/src/static/images/PleasentBeach.jpg', 'beach', '2018-08-24', false,'Enjoyed a nice relaxing day at the beach', '1');

insert into picture (title, image, picture_of, photo_date, landmark, description, event_id) 
values ('Machu Pichu Hike', 'file:///Users/david/eclipse-workspace/TravelEnthusiastFinal2/src/static/images/MachuPicchuHike.jpeg', 'building', '2017-01-21', true, '', '2');


  create table if not exists TravelEnthusiast.Experience_Type(
  id int auto_increment,
  name varchar (50),
  description varchar(250),
  experience_id int,
  primary key (ID)
  );
  
  create table if not exists TravelEnthusiast.Event_Type(
  id int auto_increment,
  name varchar (50),
  description varchar(250),
  event_id int,
   primary key (ID)
  );
  
   create table if not exists TravelEnthusiast.Location(
  id int auto_increment,
  name varchar (75),
  city varchar(75),
  state varchar(75),
  country varchar(75),
  event_id int,
  primary key (ID)
  );
  
  create table if not exists TravelEnthusiast.comments(
  ID int auto_increment,
  description varchar(500),
  event_ID int,
  user_ID int,
  primary key (ID)
  );
  
  alter table comments
  add column 
  (posted_date timestamp default now());
  
  insert into comments
  (description, event_id, user_id)
  values ('Loved the story. Seems like you had a great time.', '1', '2');
  
  alter table Experience
  add constraint user_id_FK foreign key (user_id) references user(id);
  
  alter table Experience_Type
  add constraint experience_id_fk  foreign key (experience_id) references Experience(ID);
  
  alter table picture
  add constraint experience_id_picture_fk foreign key (experience_id) references Experience(ID);
  
  alter table picture
  add constraint event_id_pciture_fk foreign key (event_id) references event(id);
  
  alter table event
  add constraint experience_id_event_fk foreign key (experience_id) references Experience (ID);
  
  alter table location
  add constraint event_id_fk foreign key (event_id) references event(id);
  
  alter table Event_Type
  add constraint event_id_event_type_fk foreign key (event_id) references event(id);
  
  alter table Experience
  drop foreign key user_id_FK ;
  
  alter table comments
  add constraint comments_event_id_fk foreign key (event_id) references event(id);
  
  alter table comments 
  add constraint comments_user_id_fk foreign key (user_id) references user(id);
  
  alter table Experience
  add unique(title);