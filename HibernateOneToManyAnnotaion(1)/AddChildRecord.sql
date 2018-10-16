select customer0_.cid as cid1_0_0_, customer0_.cname as cname2_0_0_, item1_.cid_fk as cid_fk4_1_1_, item1_.item_id as item_id1_1_1_, item1_.item_id as item_id1_1_2_, item1_.item_name as item_nam2_1_2_, item1_.price as price3_1_2_ from customer customer0_ left outer join Item item1_ on customer0_.cid=item1_.cid_fk where customer0_.cid='103'

select item_.item_id, item_.item_name as item_nam2_1_, item_.price as price3_1_ from Item item_ where item_.item_id='400'

 insert into Item (item_name, price, item_id) values (?, ?, ?)
 
update Item set cid_fk=? where item_id=?