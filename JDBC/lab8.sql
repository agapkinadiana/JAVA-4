create database Weather;
use Weather;
create table inhabitant_type
(
	id_type int auto_increment primary key ,
    name_inh nvarchar(50),
    language nvarchar(50)
);
create table region
(
	id_region int auto_increment primary key,
    name nvarchar(100),
    area float(6,2),
    weather_id int references weather(weather_id),
    id_type int references inhabitant_type(id_type)
);
create table weather
(
	weather_id int auto_increment primary key,
    date date,
    temperature int,
	precipitation int
);

insert into region (name, area, weather_id, id_type) 
	values  ("Minsk", 348.8, '1', '1'),
    ("Rome", 1285, '2', '2'),
    ("Bern", 51.6, '3', '3'),
    ("London", 1572, '4', '4');
    
insert into weather (date, temperature, precipitation) 
	values ('2019-04-22', -1, 0),
    ('2019-04-21', 27, 10),
    ('2019-04-20', 19, 15),
    ('2019-04-19', 21, 7);
    
insert into weather (date, temperature, precipitation) 
	values ('2019-04-02', -8, 20);
    
insert into region (name, area, weather_id, id_type) 
	values  ("Minsk", 348.8, '5', '1');
    
insert into inhabitant_type (name_inh, language)
	values ("Belarusians", "Belarusian"),
    ("Italians", "Italian"),
    ("Swiss", "French"),
    ("British", "English");
    
    select * from weather;
    select * from inhabitant_type;
    select date, temperature, precipitation, name
		from weather, region
        where weather.weather_id = region.weather_id and region.name like 'Rome';
        
	select date, temperature, precipitation, name
		from weather, region
        where weather.weather_id = region.weather_id and (temperature <0  and precipitation >10);
        
	select date, temperature, precipitation, name, language
		from weather, region, inhabitant_type
        where weather.weather_id = region.weather_id and region.id_type = inhabitant_type.id_type
			and language like 'French' and date >  curdate() - interval 7 day;
            
	select avg(temperature), name, area, date
		from weather, region
        where weather.weather_id = region.weather_id and area > '350' and date >  curdate() - interval 7 day
        group by name, area, date;
            

	

