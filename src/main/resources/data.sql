
insert into user_info(id, version, created, updated, first_name, last_name, user_name, email, password,active)
    values (1001, 1, now(), now(), 'Admin', 'Jack', 'admin', 'admin@admin.hu', 'asd', true);

insert into user_info(id, version, created, updated, first_name, last_name, user_name, email, password, active)
values (1002, 1, now(), now(), 'User', 'John', 'john', 'john@admin.hu', 'bsd', true);


-- insert into role_info(id, version, created, updated, name, user_id)
-- values (1001, 1, now(), now(), 'admin', (select id from user_info where email='admin@admin.hu'));
--
-- insert into role_info(id, version, created, updated, name, user_id)
-- values (1002, 1, now(), now(), 'user', (select id from user_info where email='john@admin.hu'));

insert into country(id, version, created, updated, name, sign)
    values(1001, 1, now(), now(), 'Hungary', 'H');
insert into country(id, version, created, updated, name, sign)
    values(1002, 1, now(), now(),'USA', 'US');
insert into country(id, version, created, updated, name, sign)
    values(1003, 1, now(), now(),'Russia', 'RU');
insert into country(id, version, created, updated, name, sign)
    values(1004, 1, now(), now(),'Ukraine', 'U');
insert into country(id, version, created, updated, name, sign)
    values(1005, 1, now(), now(),'Pakistan', 'PK');
insert into country(id, version, created, updated, name, sign)
    values(1006, 1, now(), now(),'Indonesia', 'ID');
insert into country(id, version, created, updated, name, sign)
    values(1007, 1, now(), now(),'Japan', 'JP');
insert into country(id, version, created, updated, name, sign)
    values(1008, 1, now(), now(),'Nigeria', 'NG');
insert into country(id, version, created, updated, name, sign)
    values(1009, 1, now(), now(),'Mexico', 'MX');
insert into country(id, version, created, updated, name, sign)
    values(1010, 1, now(), now(),'Betelgeuse', 'Bt');
insert into country(id, version, created, updated, name, sign)
    values(1011, 1, now(), now(),'Earth', 'ETH');
insert into country(id, version, created, updated, name, sign)
values(1012, 1, now(), now(),'United Kingdom', 'UK');

commit;

insert into person (id, version, created, updated, name, personal_id, country)
values (1000, 1, now(), now(), 'Zaphod Beeblebrox', '12345678901', (select id from country where sign='Bt'));

insert into person(id, version, created, updated, name, personal_id, country)
values (1001, 1, now(), now(), 'Ford Prefect', '23456789012', (select id from country where sign='ETH'));

insert into person(id, version, created, updated, name, personal_id, country)
values (1002, 1, now(), now(), 'Tricia McMillan', '34567890123', (select id from country where sign='ETH'));

insert into person(id, version, created, updated, name, personal_id, country)
values (1003, 1, now(), now(), 'Marvin The Robot','45678901323', (select id from country where sign='Bt'));

insert into person(id, version, created, updated, name, personal_id, country)
values (1004, 1, now(), now(), 'Arthur Dent','56789013234', (select id from country where sign='UK'));

insert into person(id, version, created, updated, name, personal_id, country)
values (1005, 1, now(), now(), 'Slartibartfas','67890132345', (select id from country where sign='Bt'));

insert into person(id, version, created, updated, name, personal_id, country)
values (1006, 1, now(), now(), 'Humma Kavula','78901323456', (select id from country where sign='Bt'));

commit;

insert into company(id,version, created, updated, name, tax_id, country)
values(1000, 1, now(), now(), 'Google',  '131313131', (select id from country where sign='US'));

commit;