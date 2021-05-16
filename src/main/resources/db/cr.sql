begin;
drop schema if exists cookbook cascade;
create schema cookbook;
drop table if exists cookbook.typeOfDish;
create table cookbook.typeOfDish(
                                    id_type_of_dish SERIAL,
                                    type_of_dish varchar(20),
                                    Primary Key (id_type_of_dish)
);
drop table if exists cookbook.users;
create table cookbook.users(
                               id_user SERIAL,
                               Login VARCHAR (32) NOT NULL ,
                               Password VARCHAR (64) NOT NULL ,
                               Updated timestamp,
                               Status varchar(32),
                               PRIMARY KEY (id_user)

);

drop table if exists cookbook.role;
create table cookbook.role(
                                  id_role SERIAL,
                                  Name_Role varchar(32),
                                  PRIMARY KEY (id_role)
);
drop table if exists cookbook.user_role;
create table cookbook.user_role(
                                   id_user_role SERIAL,
                                   id_user INTEGER references cookbook.users on delete cascade ,
                                   id_role INTEGER references cookbook.role on delete cascade ,
                                   PRIMARY KEY (id_user_role)
);

drop table if exists cookbook.recipe;
create table cookbook.recipe(
                                id_recipe SERIAL,
                                id_type_of_dish INTEGER references cookbook.typeOfDish on delete cascade ,
                                id_user INTEGER references cookbook.users on delete cascade ,
                                Name varchar(32) NOT NULL ,
                                Description text NOT NULL ,
                                Time varchar(20) NOT NULL ,
                                Calorie numeric(4,1),
                                Protein numeric(3,1),
                                Fat numeric(3,1),
                                Carbohydrate numeric(3,1),
                                Value numeric(4,1),
                                Url_photo text,
                                Primary Key (id_recipe)
);


drop table if exists cookbook.favorite;
create table cookbook.favorite(
  id_favorite SERIAL,
  id_user INTEGER references cookbook.users on delete cascade ,
  id_recipe INTEGER references cookbook.recipe on delete cascade ,
  Primary Key (id_favorite)
);

drop table if exists cookbook.ingredient;
create table cookbook.ingredient(
                                  id_ingredient SERIAL,
                                  Ingredient VARCHAR(32),
                                  Primary Key (id_ingredient)
);
drop table if exists cookbook.unit;
create table cookbook.unit
(
    id_unit SERIAL,
    Unit    varchar(20),
    Primary Key (id_unit)

);
drop table if exists cookbook.product;
create table cookbook.product(
                                  id_product SERIAL,
                                  id_recipe INTEGER references cookbook.recipe on delete cascade ,
                                  id_ingredient INTEGER references cookbook.ingredient on delete cascade ,
                                  Quantity numeric(4,1),
                                  id_unit INTEGER references cookbook.unit on delete cascade ,
                                  Primary Key (id_product)
);
insert into cookbook.users values (1,'Ivanov','hello');
insert into cookbook.typeOfDish  values (1,'soup');
insert into cookbook.recipe (id_recipe, id_type_of_dish, id_user) values (1,1,1);
insert into cookbook.unit values (1,'glass');
insert into cookbook.ingredient values (1,'apple');
insert into cookbook.ingredient values (2,'orange');
insert into cookbook.product values (3,3,1,3,1);
insert into cookbook.product values (2,2,2,3,1);
insert into cookbook.recipe  values (2,1,1);
insert into cookbook.product values (3,2,1,3,1);
insert into cookbook.recipe values (5,1,1,'tort', 'kf;lf;','5 min',45,1,1,1,1,'kflf');
insert into cookbook.role  values (1, 'USER');
insert into cookbook.role  values (2, 'ADMIN');
insert into cookbook.user_role values (1,1);
update  cookbook.recipe set name='cake' where id_recipe=1;
select r.*
    from cookbook.recipe r inner join cookbook.product p on r.id_recipe = p.id_recipe
    inner join cookbook.ingredient i on p.id_ingredient = i.id_ingredient
    where i.ingredient in ('orange','apple');

commit ;

select r.*
    from cookbook.recipe r
    where position(lower('t') in (lower(concat(r.name))))<>0;


select * from cookbook.recipe;
select * from cookbook.product;
select *from cookbook.ingredient;


select r.name,r.description, r.time,i.ingredient,u.Unit,p.quantity
    from cookbook.recipe r inner join cookbook.product p on r.id_recipe=p.id_recipe
    inner join cookbook.unit u on p.id_unit=u.id_unit
    inner join cookbook.ingredient i on p.id_ingredient=i.id_ingredient;


DELETE FROM cookbook.recipe
WHERE id_recipe = 1;