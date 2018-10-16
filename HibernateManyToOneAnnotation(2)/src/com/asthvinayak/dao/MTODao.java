package com.asthvinayak.dao;

import java.util.List;

import com.asthvinayak.entity.ItemDTO;

public interface MTODao {

	public void saveManyToOne(List<ItemDTO> listItems);

}
