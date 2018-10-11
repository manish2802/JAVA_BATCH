 select customer0_.custid as custid1_0_0_, customer0_.cust_name as cust_nam2_0_0_ from customer_otm_xml customer0_ where customer0_.custid=?
 select items0_.cid_fk as cid_fk4_1_0_, items0_.item_id as item_id1_1_0_, items0_.item_id as item_id1_1_1_, items0_.item_name as item_nam2_1_1_, items0_.price as price3_1_1_ from item_otm_xml items0_ where items0_.cid_fk=?
 update item_otm_xml set cid_fk=null where cid_fk=?
delete from item_otm_xml where item_id=?
delete from item_otm_xml where item_id=?
delete from customer_otm_xml where custid=?
