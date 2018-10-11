select item_.item_id, item_.item_name as item_nam2_1_, item_.price as price3_1_ from item_otm_xml item_ where item_.item_id=?
select item_.item_id, item_.item_name as item_nam2_1_, item_.price as price3_1_ from item_otm_xml item_ where item_.item_id=?
insert into customer_otm_xml (cust_name, custid) values (?, ?)
insert into item_otm_xml (item_name, price, item_id) values (?, ?, ?)
insert into item_otm_xml (item_name, price, item_id) values (?, ?, ?)
update item_otm_xml set cid_fk=? where item_id=?
update item_otm_xml set cid_fk=? where item_id=?