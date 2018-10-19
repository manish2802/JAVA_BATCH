select item_.item_id, item_.cid_fk as cid_fk4_1_, item_.item_name as item_nam2_1_, item_.price as price3_1_ from Item_otm_bi item_ where item_.item_id=?
select item_.item_id, item_.cid_fk as cid_fk4_1_, item_.item_name as item_nam2_1_, item_.price as price3_1_ from Item_otm_bi item_ where item_.item_id=?
 insert into customer_otm_bi (cname, cid) values (?, ?)
 insert into Item_otm_bi (cid_fk, item_name, price, item_id) values (?, ?, ?, ?)
 insert into Item_otm_bi (cid_fk, item_name, price, item_id) values (?, ?, ?, ?)
 update Item_otm_bi set cid_fk=? where item_id=?
 update Item_otm_bi set cid_fk=? where item_id=?