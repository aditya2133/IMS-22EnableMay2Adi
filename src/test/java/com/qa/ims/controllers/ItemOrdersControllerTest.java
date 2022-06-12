package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemOrdersController;
import com.qa.ims.persistence.dao.ItemOrdersDAO;
import com.qa.ims.persistence.domain.ItemOrders;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemOrdersControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private ItemOrdersDAO dao;

	@InjectMocks
	private ItemOrdersController controller;

	@Test
	public void testCreate() {
		final Long ordId = 5L, itId = 2L, itQua = 52L;
		final ItemOrders created = new ItemOrders(ordId, itId, itQua);

		Mockito.when(utils.getLong()).thenReturn(ordId, itId, itQua);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<ItemOrders> itemOrders = new ArrayList<>();
		itemOrders.add(new ItemOrders(20L,2L,4L,12L));

		Mockito.when(dao.readAll()).thenReturn(itemOrders);

		assertEquals(itemOrders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

//	@Test
//	public void testUpdate() {
//		ItemOrders updated = new ItemOrders(1L, 50L);
//
//		Mockito.when(this.utils.getLong()).thenReturn(1L);
//		Mockito.when(this.utils.getLong()).thenReturn(updated.getItemQuantity());
//		Mockito.when(this.dao.update(updated)).thenReturn(updated);
//
//		assertEquals(updated, this.controller.update());
//
//		Mockito.verify(this.utils, Mockito.times(2)).getLong();
//		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
//	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}
