package com.asthvinayak.dao;

import java.util.Set;

import com.asthvinayak.entity.ItemDTO;

public interface MTMDao {

	public void saveManyToMany(Set<ItemDTO> listItems);


}
