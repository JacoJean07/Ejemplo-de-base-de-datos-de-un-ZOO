/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     30/1/2023 21:33:16                           */
/*==============================================================*/


drop table if exists ANIMALES;

drop table if exists ESPECIES;

drop table if exists ZOOLOGICOS;

/*==============================================================*/
/* Table: ANIMALES                                              */
/*==============================================================*/
create table ANIMALES
(
   IDANIMAL             int not null,
   IDZOOLOGICO          int,
   IDESPECIE            int,
   NOMBREANIMAL         char(25) not null,
   SEXO                 char(7) not null,
   ANIONACIMIENTO       int not null,
   PAISORIGEN           char(56),
   CONTINENTEORIGEN     char(15) not null,
   primary key (IDANIMAL)
);

/*==============================================================*/
/* Table: ESPECIES                                              */
/*==============================================================*/
create table ESPECIES
(
   IDESPECIE            int not null,
   NOMBREVULGAR         char(25) not null,
   NOMBRECIENTIFICO     char(35) not null,
   FAMILIA              char(25) not null,
   PELIGROEXTINCION     bool,
   primary key (IDESPECIE)
);

/*==============================================================*/
/* Table: ZOOLOGICOS                                            */
/*==============================================================*/
create table ZOOLOGICOS
(
   IDZOOLOGICO          int not null,
   ZOONOMBRE            char(25) not null,
   ZOOCIUDAD            varchar(85) not null,
   ZOOPAIS              char(25) not null,
   ZOOTAMANIO           int,
   ZOOPRESUPUESTOANUAL  decimal(12,2),
   primary key (IDZOOLOGICO)
);

alter table ANIMALES add constraint FK_PERTENECE foreign key (IDESPECIE)
      references ESPECIES (IDESPECIE) on delete restrict on update restrict;

alter table ANIMALES add constraint FK_REGISTRA foreign key (IDZOOLOGICO)
      references ZOOLOGICOS (IDZOOLOGICO) on delete restrict on update restrict;

