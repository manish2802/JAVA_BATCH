create table item_mto (item_id varchar2(255 char) not null, item_name varchar2(10 char), price double precision, cid_pk varchar2(255 char), primary key (item_id))
alter table item_mto add constraint FKpv3ayqe3q7tkpqupb1xbd2sqx foreign key (cid_pk) references customer_mto
select customer_.cid, customer_.cname as cname2_0_ from customer_mto customer_ where customer_.cid=?
insert into customer_mto (cname, cid) values (?, ?)
insert into item_mto (cid_pk, item_name, price, item_id) values (?, ?, ?, ?)
insert into item_mto (cid_pk, item_name, price, item_id) values (?, ?, ?, ?)