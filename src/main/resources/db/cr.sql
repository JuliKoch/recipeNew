begin;
drop schema if exists cookbook cascade;
create schema cookbook;
drop table if exists cookbook.users;
create table cookbook.users(
                                   ID_User SERIAL,
                                   Login VARCHAR (32),
                                   Password VARCHAR (32),
                                   PRIMARY KEY (ID_User)

);

drop table if exists cookbook.typeOfDish;
create table cookbook.typeOfDish(
                                    ID_TypeOfDish SERIAL,
                                    TypeOfDish varchar(20),
                                    Primary Key (ID_TypeOfDish)
);
drop table if exists cookbook.recipe;
create table cookbook.recipe(
                                ID_Recipe SERIAL,
                                ID_TypeOfDish INTEGER references cookbook.typeOfDish on delete cascade ,
                                ID_User INTEGER references cookbook.users on delete cascade ,
                                Name varchar(32),
                                Description text,
                                Time varchar(20),
                                Calorie numeric(4,1),
                                Protein numeric(3,1),
                                Fat numeric(3,1),
                                Carbohydrate numeric(3,1),
                                Value numeric(4,1),
                                Url_photo text,
                                Primary Key (ID_Recipe)
);


drop table if exists cookbook.favorite;
create table cookbook.favorite(
  ID_Favorite SERIAL,
  ID_User INTEGER references cookbook.users on delete cascade ,
  ID_Recipe INTEGER references cookbook.recipe on delete cascade ,
  Primary Key (ID_Favorite)
);

drop table if exists cookbook.ingredient;
create table cookbook.ingredient(
                                  ID_Ingredient SERIAL,
                                  Ingredient VARCHAR(32),
                                  Primary Key (ID_Ingredient)
);
drop table if exists cookbook.unit;
create table cookbook.unit
(
    ID_Unit SERIAL,
    Unit    varchar(20),
    Primary Key (ID_Unit)

);
drop table if exists cookbook.product;
create table cookbook.product(
                                  ID_List SERIAL,
                                  ID_Recipe INTEGER references cookbook.recipe on delete cascade ,
                                  ID_Ingredient INTEGER references cookbook.ingredient on delete cascade ,
                                  Quantity numeric(4,1),
                                  ID_Unit INTEGER references cookbook.unit on delete cascade ,
                                  Primary Key (ID_List)
);




commit ;