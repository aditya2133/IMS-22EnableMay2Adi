package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemOrdersDAO;
import com.qa.ims.persistence.domain.ItemOrders;
import com.qa.ims.utils.Utils;

public class ItemOrdersController implements CrudController<ItemOrders> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemOrdersDAO itoDAO;
	private Utils utils;

	public ItemOrdersController(ItemOrdersDAO itoDAO, Utils utils) {
		super();
		this.itoDAO = itoDAO;
		this.utils = utils;
	}

	@Override
	public List<ItemOrders> readAll() {
		List<ItemOrders> itemorders = itoDAO.readAll();
		for (ItemOrders itemorder : itemorders) {
			LOGGER.info(itemorder);
		}
		return itemorders;
	}

	
	public ItemOrders read2(Long orderId) {
//		LOGGER.info("Please enter order ID");
//		Long orderID = utils.getLong();
//
//		ItemOrders ito = itoDAO.read2(new ItemOrders(orderID));
//		LOGGER.info(ito);
////		List<ItemOrders> itemorders = itoDAO.read(orderId);
////		for (ItemOrders itemorder : itemorders) {
////			LOGGER.info(itemorder);
////		}
		return null; //ito;
	}

	@Override
	public ItemOrders create() {
		LOGGER.info("Please enter OrderId to which the items would be added");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter a itemid for one item which is going to be purchased ");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter quantity for said item");
		Long itemQuantity = utils.getLong();
		ItemOrders ito = itoDAO.create(new ItemOrders(orderId, itemId, itemQuantity));
		LOGGER.info("Order Updated");
		return ito;
	}

	@Override
	public ItemOrders update() {
		LOGGER.info("Please enter the orderitems id you would like to update");
		Long orderItemId = utils.getLong();

		LOGGER.info("Please enter a new quantity");
		Long itemQuantity = utils.getLong();

		ItemOrders ito = itoDAO.update(new ItemOrders(orderItemId, itemQuantity));
		LOGGER.info("Order Updated");
		return ito;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the orderitems id of the item you would like to delete");
		Long orderItemId = utils.getLong();
		return itoDAO.delete(orderItemId);

	}

}
