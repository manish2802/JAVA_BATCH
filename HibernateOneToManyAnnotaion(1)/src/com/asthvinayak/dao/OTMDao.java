package com.asthvinayak.dao;

import java.io.Serializable;

import com.asthvinayak.entity.CustomerDTO;
import com.asthvinayak.entity.ItemDTO;

public interface OTMDao {

	public Serializable saveOneToMany(CustomerDTO customer);

	public void removeParent(Serializable id);

	public CustomerDTO getParentLazy(Serializable id);

	public CustomerDTO getParentEarly(Serializable id);

	public CustomerDTO removeChild(Serializable id1, Serializable id2);

	public CustomerDTO addNewchild(Serializable id, ItemDTO item);
	
	public CustomerDTO getParentLazyHQL() throws InterruptedException;

}
