CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (9, 'q'), (5, 'a'), (8, 'z'), (2, 'w'), (6, 's');

select * from company;

insert into person(id, name, company_id) values (3, 'p', 9), (1, 'l', 6), (2, 'o', 5), (4, 'k', 5),
(5, 'm', 5), (6, 'i', 2), (7, 'j', 6);

select * from person;

select p.name, c.name as company_name from person p left join company c on p.company_id = c.id where c.id != 5;

select c.id, c.name, count(p.company_id) from company c, person p where c.id = p.company_id
group by c.id
having count(p.company_id) =
(select count(p.company_id) as counter from company as c join person p on p.company_id = c.id
group by c.name order by counter desc limit 1);