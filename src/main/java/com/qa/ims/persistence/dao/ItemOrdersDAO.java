package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.ItemOrders;
import com.qa.ims.utils.DBUtils;

public class ItemOrdersDAO implements Dao<ItemOrders>{

	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public ItemOrders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderItemId = resultSet.getLong("orderitems_id");
		Long orderId = resultSet.getLong("order_id");
		Long itemId = resultSet.getLong("item_id");
		Long itemQuantity = (long) resultSet.getInt("item_quantity");
		Long itemTotal = resultSet.getLong("total");
		return new ItemOrders(orderItemId, orderId, itemId, itemQuantity, itemTotal);
	
	}
	public ItemOrders modelFromResultSet2(ResultSet resultSet) throws SQLException {
		Long orderItemId = resultSet.getLong("orderitems_id");
		Long orderId = resultSet.getLong("order_id");
		Long itemId = resultSet.getLong("item_id");
		Long itemQuantity = (long) resultSet.getInt("item_quantity");
//		Long itemTotal = resultSet.getLong("total");
		return new ItemOrders(orderItemId, orderId, itemId, itemQuantity);
	
	}
	
	@Override
	public List<ItemOrders> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT orders.customer_id, first_name,orderitems_id, order_items.order_id,items.item_id, item_name, item_quantity,price, sum(price*item_quantity) AS total FROM order_items\r\n"
						+ "Join orders on orders.order_id = order_items.order_id\r\n"
						+ "Join customers ON customers.customer_id = orders.customer_id\r\n"
						+ "Join items on order_items.item_id = items.item_id\r\n"
						+ "	--     WHERE order_items.order_id = 8\r\n"
						+ "	Group By order_id \r\n"
						+ " ORDER BY order_id;");) {
			List<ItemOrders> itemorders = new ArrayList<>();
			while (resultSet.next()) {
				itemorders.add(modelFromResultSet(resultSet));
			}
			return itemorders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public ItemOrders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet2(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public ItemOrders read(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_items WHERE order_id = ?");) {
			statement.setLong(1, orderId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet2(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public ItemOrders create(ItemOrders itemorders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items(order_id, item_id, item_quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, itemorders.getOrderId());
			statement.setLong(2, itemorders.getItemId());
			statement.setLong(3, itemorders.getItemQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public ItemOrders update(ItemOrders itemorders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE order_items SET item_quantity = ? WHERE orderitems_id = ?");) {
			
			statement.setLong(1, itemorders.getItemQuantity());
			statement.setLong(2, itemorders.getOrderItemId());
			statement.executeUpdate();
//			return read(itemorders.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long orderItemid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE orderitems_id = ?");) {
			statement.setLong(1, orderItemid);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	
	
	
	
	// To return items of a single order by inputing order id
	
	public ItemOrders read2(ItemOrders itemorders) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//			
//			PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_items WHERE order_id = ?");) {
//			statement.setLong(1, itemorders.getOrderId());
////			ResultSet resultset = statement.executeQuery();
////			while (resultset.next()) {
////				LOGGER.info(resultset);
////			}
//			try (ResultSet resultSet = statement.executeQuery();) {
//				resultSet.next();
//				return modelFromResultSet(resultSet);
//			}
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
		return null;
	}

	
	
	

	
}
